/**
 * @(#)WorkBean.java 2018年4月10日
 * Copyright(C) 2018年4月10日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webmeng.simulator.task.channel.IWorkChannel;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class WorkBean extends TimingBean {
	public static final Logger LOGGER = LoggerFactory.getLogger(WorkBean.class);

	private Object task;
	private IWorkChannel workChannel;
	private String uuid;
	
	public Object getTask() {
		return task;
	}
	public void setTask(Object task) {
		this.task = task;
	}
	public IWorkChannel getWorkChannel() {
		return workChannel;
	}
	public void setWorkChannel(IWorkChannel workChannel) {
		this.workChannel = workChannel;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Override
	public String toString(){
		return "uuid="+uuid+",task="+task;
	}
	
}
