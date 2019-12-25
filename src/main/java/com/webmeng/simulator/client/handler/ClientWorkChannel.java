/**
 * @(#)ClientWorkChannel.java 2017年12月29日
 * Copyright(C) 2017年12月29日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webmeng.douyin.protocol.bean.AckBean;
import com.webmeng.douyin.protocol.bean.OptClickBean;
import com.webmeng.douyin.protocol.bean.OptDelEnterBean;
import com.webmeng.douyin.protocol.bean.OptDragBean;
import com.webmeng.douyin.protocol.bean.OptEnterBean;
import com.webmeng.douyin.protocol.bean.OptFinishBean;
import com.webmeng.douyin.protocol.bean.OptFlushBean;
import com.webmeng.douyin.protocol.bean.OptLaunchBean;
import com.webmeng.douyin.protocol.bean.OptLongPressBean;
import com.webmeng.douyin.protocol.bean.OptRestartAppBean;
import com.webmeng.douyin.protocol.bean.OptRestartPhone;
import com.webmeng.douyin.protocol.bean.OptSlideBean;
import com.webmeng.douyin.protocol.bean.OptUploadImgBean;
import com.webmeng.douyin.protocol.bean.OptVerificationCodeBean;
import com.webmeng.douyin.protocol.channel.AbtractClientWorkChannel;

import io.netty.channel.ChannelHandlerContext;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class ClientWorkChannel extends AbtractClientWorkChannel {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ClientWorkChannel.class);
	private String uuid;
	
	public ClientWorkChannel(ChannelHandlerContext ctx,boolean isServer) {
		super(ctx,isServer);
	}

	/*@Override
	public boolean reportStatus(boolean busyFlag) throws Exception {
		StatusBean status=new StatusBean();
		status.setAckNum(Long.valueOf(MathUtils.getRandomString(16)));
		status.setBusyFlag(busyFlag);
		return send(status);
	}

	@Override
	public boolean handler(TaskBean taskBean) throws Exception {
		LOGGER.info("taskBean IS [{}]",taskBean);
		sendAck(taskBean);
		
		if(taskBean.getType()==TaskBean.UPLOAD_RETENT){
			ReportBean reportBean=new ReportBean();
			reportBean.setType(ReportBean.SYNC_SUCC);
			send(reportBean);
			return true;
		}
		
		SimulatorInfoManager.handlerTask(taskBean,this,uuid);
		return true;
	}

	@Override
	public boolean handler(AckBean ackBean) throws Exception {
		LOGGER.info("GET A ACKBean[{}]",ackBean.getAckNum());
		return true;
	}

	@Override
	public boolean handler(WifiSelectBean wifiSelect) throws Exception {
		LOGGER.info("wifiSelect is [{}]",wifiSelect);
		DeviceInfo deviceInfo=SimulatorInfoManager.getDeviceInfo();
		deviceInfo.setExt2(wifiSelect.getWifiName()+"#"+wifiSelect.getWifiHz());
		ctx.writeAndFlush(deviceInfo);
//		SimulatorInfoManager.sendProviderAuth(this,uuid);
//		SimulatorInfoManager.sendReqAuth(this,uuid);
		return true;
	}

	@Override
	public boolean handler(ReqAuthorizationBean reqAuthorization) throws Exception {
		LOGGER.info("reqAuthorization:[{}]",reqAuthorization);
		RespAuthorizationBean resp=new RespAuthorizationBean();
		resp.setCode(RespAuthorizationBean.SUCCESS);
		JSONObject json=new JSONObject();
		json.put("token", MathUtils.getRandomString(16));
		resp.setData(json.toJSONString());
		resp.setUuid(reqAuthorization.getUuid());
		resp.setAckNum(reqAuthorization.getAckNum());
		ctx.writeAndFlush(resp);
		return true;
	}

	@Override
	public boolean handler(RespAuthorizationBean respAuthorization) throws Exception {
		LOGGER.info("respAuthorization DATA:[{}]",respAuthorization);
		return true;
	}*/
    
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Override
	public boolean handler(OptClickBean optClickBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptDragBean optDragBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptEnterBean optEnterBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptDelEnterBean optDelEnterBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptUploadImgBean optUploadImgBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptSlideBean optSlideBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptLaunchBean optLaunchBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptFinishBean optFinishBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptFlushBean OptFlushBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean handler(AckBean ackBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptRestartAppBean optRestartAppBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptRestartPhone optRestartPhone) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptLongPressBean optLongPressBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handler(OptVerificationCodeBean optVerificationCodeBean) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
}
