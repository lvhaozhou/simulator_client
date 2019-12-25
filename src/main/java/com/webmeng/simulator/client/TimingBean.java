/**
 * @(#)TimingBean.java 2018年4月10日
 * Copyright(C) 2018年4月10日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class TimingBean implements Comparable<TimingBean>{
	public static final Logger LOGGER = LoggerFactory.getLogger(TimingBean.class);

	private long timingTime;
	private String tokenId;
	
	@Override
	public int compareTo(TimingBean o) {
	    if(this.getTimingTime()>o.getTimingTime()){
	    	return 1;
	    }
	    return -1;
	}

	@Override
	public int hashCode(){
		return tokenId.hashCode();
	}
	
	@Override
	public boolean equals(Object tabBean){
		if(tabBean==null){
			return false;
		}
		if(!(tabBean instanceof TimingBean)){
			return false;
		}
		TimingBean temp=(TimingBean)tabBean;
		if(temp.getTokenId()==null){
			return false;
		}
		if(!temp.getTokenId().equals(this.getTokenId())){
			return false;
		}
		return true;
	}
	
	public long getTimingTime() {
		return timingTime;
	}

	public void setTimingTime(long timingTime) {
		this.timingTime = timingTime;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
	
}
