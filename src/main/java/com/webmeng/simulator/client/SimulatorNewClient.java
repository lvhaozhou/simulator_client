/**
 * @(#)SimulatorClient.java 2017年12月29日
 * Copyright(C) 2017年12月29日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webmeng.douyin.protocol.SimulatorObjectDecoder;
import com.webmeng.douyin.protocol.SimulatorObjectEncoder;
import com.webmeng.simulator.client.handler.ClientHandler;
import com.webmeng.simulator.client.util.PropertiesUtil;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class SimulatorNewClient {
	public static final Logger LOGGER = LoggerFactory.getLogger(SimulatorNewClient.class);

	public static final String LOGIN_HOST=PropertiesUtil.getValue("login.host","http://localhost:14302");
	
    public static void start(String host,int port){
    	connect(host,port);
//    	connect("121.43.190.223",4202);	
//    	connect("121.43.190.223",4202);
//    	connect("121.43.190.223",10038);
//    	connect("172.18.245.11",14202);
    }
    
    private static void connect(String ip,int port){
    	EventLoopGroup workGroup=new NioEventLoopGroup(1);
		
		try{
			Bootstrap b=new Bootstrap();
			b.group(workGroup).channel(NioSocketChannel.class)
			    .option(ChannelOption.TCP_NODELAY, true)
			    .handler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						int writerIdleTimeSeconds = 0;
                    	int readerIdleTimeSeconds = 6;                            
                        int allIdleTimeSeconds =0;
                        ch.pipeline().addFirst("idleStateHandler", new IdleStateHandler(readerIdleTimeSeconds,
                                writerIdleTimeSeconds, allIdleTimeSeconds));
                        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024*1024*10, 0, 4, 0, 4));
                        ch.pipeline().addLast(new SimulatorObjectDecoder());
                        ch.pipeline().addLast(new SimulatorObjectEncoder());
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
