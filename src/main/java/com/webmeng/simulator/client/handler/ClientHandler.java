/**
 * @(#)ClientHandler.java 2017年7月7日
 * Copyright(C) 2017年7月7日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webmeng.douyin.protocol.bean.RegisterBean;
import com.webmeng.douyin.protocol.channel.IWorkChannel;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.AttributeKey;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
	public static final Logger LOGGER = LoggerFactory.getLogger(ClientHandler.class);
	
	private AttributeKey<IWorkChannel> attrKeyWC = AttributeKey.valueOf("workchannel");
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		LOGGER.info("channelActive");
		ClientWorkChannel channel = new ClientWorkChannel(ctx,false);
		ctx.attr(attrKeyWC).set(channel);
		RegisterBean start = new RegisterBean();
		start.setBizVer("aaa");
		start.setCheckWifi(11);
		start.setUuid("123456a");
		start.setMac("123456");
		/*WifiReportBean report=new WifiReportBean();
		report.setWifiHz("2.4G");
		report.setWifiName("cisco");
		report.setUuid(MathUtils.getRandomString(16));*/
		
		channel.setUuid("123456aaaa");
		//channel.sendHeart();
		ctx.writeAndFlush(start);
		
	}
	
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		LOGGER.info("channelRegistered");
	}
	
	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		LOGGER.info("channelUnregistered");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		IWorkChannel channel =ctx.attr(attrKeyWC).get();
		try{
			channel.handler(msg);
		}catch(Exception e){
			LOGGER.error("channelRead ERROR");
			channel.close();
		}
	}
  
    @Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    	LOGGER.error("exceptionCaught",cause);
    	ctx.close();
    }
    
    @Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    	LOGGER.debug("userEventTriggered");
    	if (IdleStateEvent.class.isAssignableFrom(evt.getClass())) {
			IdleStateEvent event = (IdleStateEvent) evt;
			if (event.state() == IdleState.READER_IDLE) {
		    	IWorkChannel channel =ctx.attr(attrKeyWC).get();
				channel.sendHeart();
            } 
		}
	}
	
}
