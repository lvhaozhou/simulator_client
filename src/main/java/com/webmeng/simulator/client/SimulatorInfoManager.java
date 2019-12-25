/**
 * @(#)SimulatorInfoManager.java 2018年1月2日
 * Copyright(C) 2018年1月2日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client;


import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webmeng.simulator.client.util.PropertiesUtil;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class SimulatorInfoManager {
	public static final Logger LOGGER = LoggerFactory.getLogger(SimulatorInfoManager.class);

	private static final String uuid=UUID.randomUUID().toString().replaceAll("-", "");
	
	private static int busy=0;
	private static String sysVer=PropertiesUtil.getValue("simulator.version", "1.0");
	private static String mac="mac信息";
	
	/*public static DeviceInfo getDeviceInfo(){
		DeviceInfo info=new DeviceInfo();
		info.setBusyFlag(false);
		info.setMac(mac);
		info.setSysVer("2.0.4");
		info.setBizVer("12.1.30.9");
		info.setHeartVer("6.2.5");
		info.setModel("Redmi Note 4");
		//info.setUuid(UUID.randomUUID().toString().replaceAll("-", "")+UUID.randomUUID().toString().replaceAll("-", ""));
		info.setUuid("123456a");
		return info;
	}*/
	
	public static String getUuid(){
		return uuid;
	}

	public static int getBusy() {
		return busy;
	}

	public static void setBusy(int busy) {
		SimulatorInfoManager.busy = busy;
	}
	
	public static String getSysVer() {
		return sysVer;
	}

	public static void setSysVer(String sysVer) {
		SimulatorInfoManager.sysVer = sysVer;
	}

	public static String getMac() {
		return mac;
	}

	public static void setMac(String mac) {
		SimulatorInfoManager.mac = mac;
	}
	
	/*public static void reportStatus(boolean busyFlag,IWorkChannel workChannel,String uuid){
		StatusBean status=new StatusBean();
		status.setAckNum(Long.valueOf(MathUtils.getRandomString(16)));
		status.setBusyFlag(busyFlag);
		try {
			WorkBean task=new WorkBean();
			task.setUuid(uuid);
			task.setTask(status);
			task.setTokenId(RandomUtils.getRandomUUID());
			task.setWorkChannel(workChannel);
			long score=RandomUtils.getRandomLongNum(10)+1;
			TimingThead.delayTask(task,1);
		} catch (Exception e) {
			LOGGER.error("reportStatus error",e);
		}
	}*/
	
	/*public static void handlerTask(TaskBean task,IWorkChannel workChannel,String uuid){
		LOGGER.info("GET A STASK[{}]",task);
		reportStatus(false,workChannel,uuid);
	}
	
	public static void sendReqAuth(IWorkChannel workChannel,String uuid){
		WorkBean task=new WorkBean();
		ReqAuthorizationBean auth=new ReqAuthorizationBean();
		auth.setUuid(uuid);
		auth.setServerName("qq");
		auth.setAccount("123123");
		auth.setAckNum(Long.valueOf(MathUtils.getRandomString(16)));
		task.setUuid(uuid);
		task.setTask(auth);
		task.setTokenId(RandomUtils.getRandomUUID());
		task.setWorkChannel(workChannel);
		TimingThead.delayTask(task,10000);
	}
	
	public static void sendProviderAuth(IWorkChannel workChannel,String uuid){
		WorkBean task=new WorkBean();
		ProviderAuthorizationBean auth=new ProviderAuthorizationBean();
		auth.setUuid(uuid);
		auth.setAccount("123123");
		auth.setServerName("qq");
		auth.setAckNum(Long.valueOf(MathUtils.getRandomString(16)));
		task.setUuid(uuid);
		task.setTask(auth);
		task.setTokenId(RandomUtils.getRandomUUID());
		task.setWorkChannel(workChannel);
		TimingThead.delayTask(task,2000);
	}*/
	
}
