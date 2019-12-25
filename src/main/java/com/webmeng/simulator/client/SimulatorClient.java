/**
 * @(#)SimulatorClient.java 2017年12月29日
 * Copyright(C) 2017年12月29日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.webmeng.simulator.client.handler.ClientHandler;
import com.webmeng.simulator.client.util.HttpClientUtil;
import com.webmeng.simulator.client.util.PropertiesUtil;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class SimulatorClient {
	public static final Logger LOGGER = LoggerFactory.getLogger(SimulatorClient.class);

	public static final String LOGIN_HOST=PropertiesUtil.getValue("login.host","http://localhost:14302");
	
    public static void start(){
    	String resultStr=login();
    	JSONObject json=JSON.parseObject(resultStr);
    	int result=json.getInteger("result");
    	if(result==1){
    		JSONObject hostJson=json.getJSONObject("data");
    		String ip=hostJson.getString("serverIp");
    		int port=hostJson.getInteger("port");
    		connect(ip,port);
    		return;
    	}
    	String message=json.getString("message");
    	LOGGER.info("message:[{}]",message);
    }
    
    private static String login(){
    	String url=LOGIN_HOST+"/sdk_login";
		Map<String,String> paramMap=new HashMap<String,String>();
		JSONObject json=new JSONObject();
		json.put("uuid",SimulatorInfoManager.getUuid());
		json.put("sysVer", SimulatorInfoManager.getSysVer());
		json.put("busy", SimulatorInfoManager.getBusy());
		json.put("mac", SimulatorInfoManager.getMac());
		paramMap.put("login", json.toJSONString());
		String msg=HttpClientUtil.post(url, paramMap, 6000);
		System.out.println(msg);
		return msg;
    }
	
    
    private static void connect(String ip,int port){
    	EventLoopGroup workGroup=new NioEventLoopGroup();
		
		try{
			Bootstrap b=new Bootstrap();
			b.group(workGroup).channel(NioSocketChannel.class)
			    .option(ChannelOption.TCP_NODELAY, true)
			    .handler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						int writerIdleTimeSeconds = 6;
                    	int readerIdleTimeSeconds = (int) (writerIdleTimeSeconds * 1.5);                            
                        int allIdleTimeSeconds = 0;
                        ch.pipeline().addFirst("idleStateHandler", new IdleStateHandler(readerIdleTimeSeconds,
                                writerIdleTimeSeconds, allIdleTimeSeconds));
						ch.pipeline().addLast(new ClientHandler());
					}
			});
			
			ChannelFuture f=b.connect(ip,port).sync();
			f.channel().closeFuture().sync();
			
		}catch(Exception e){
			LOGGER.error("",e);
		}finally{
			workGroup.shutdownGracefully();
		}
    }
    

}
