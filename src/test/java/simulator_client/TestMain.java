/**
 * @(#)TestMain.java 2018年4月10日
 * Copyright(C) 2018年4月10日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package simulator_client;


import java.util.concurrent.ConcurrentSkipListSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webmeng.simulator.client.TimingBean;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class TestMain {
	public static final Logger LOGGER = LoggerFactory.getLogger(TestMain.class);

	/**
	 * main:TODO 请描述该方法是做什么用途的
	 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcurrentSkipListSet<TimingBean> list = new ConcurrentSkipListSet<TimingBean>();
		
		TimingBean time3=new TimingBean();
		time3.setTimingTime(1111);
		time3.setTokenId("111");
		list.add(time3);
		
		TimingBean time2=new TimingBean();
		time2.setTimingTime(1111);
		time2.setTokenId("3333");
		list.add(time2);
		
		TimingBean time=new TimingBean();
		time.setTimingTime(1111);
		time.setTokenId("222");
		list.add(time);
		
		System.out.println(list.size());
		
		System.out.println(list.pollFirst());
	
	}
}
