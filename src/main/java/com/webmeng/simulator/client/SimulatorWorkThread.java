/**
 * @(#)ReportThread.java 2018年1月11日
 * Copyright(C) 2018年1月11日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webmeng.simulator.task.bean.ProviderAuthorizationBean;
import com.webmeng.simulator.task.bean.ReqAuthorizationBean;
import com.webmeng.simulator.task.bean.StatusBean;
import com.webmeng.simulator.task.bean.TaskBean;
import com.webmeng.simulator.task.channel.IWorkChannel;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class SimulatorWorkThread implements Runnable{
	public static final Logger LOGGER = LoggerFactory.getLogger(SimulatorWorkThread.class);

	private static BlockingQueue<WorkBean> queue=new LinkedBlockingQueue<WorkBean>();
	
	@Override
	public void run() {
		while(true){
			try{
				WorkBean data=queue.take();
				Object task=data.getTask();
				IWorkChannel channel=data.getWorkChannel();
				
				if(task instanceof StatusBean){
					LOGGER.info("模拟器[{}]上报空闲状态",data.getUuid());
					channel.send(task);
					continue;
				}
//				if(task instanceof ReqAuthorizationBean){
//					LOGGER.info("模拟器[{}]请求授权",data.getUuid());
//					channel.send(task);
//					continue;
//				}
//				if(task instanceof ProviderAuthorizationBean){
//					LOGGER.info("模拟器[{}]提供授权",data.getUuid());
//					channel.send(task);
//					continue;
//				}
			}catch(Exception e){
				LOGGER.error("ReportThread error");
			}
		}
	}
	
	public static void addTask(WorkBean workBean){
		queue.add(workBean);
	}
	
	
}
