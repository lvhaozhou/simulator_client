/**
 * @(#)StepBeanTimingThead.java 2018年1月24日
 * Copyright(C) 2018年1月24日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webmeng.simulator.client.util.RandomUtils;
import com.webmeng.simulator.client.util.TimingQueue;

/**
 * 切换任务的定时
 * 
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class TimingThead  implements Runnable{
	public static final Logger LOGGER = LoggerFactory.getLogger(TimingThead.class);

	private static TimingQueue<TimingBean> queue = new TimingQueue<TimingBean>();

	@Override
	public void run(){
		while(true){
			try{
				handler();
			}catch(Exception e){
				LOGGER.error("",e);
			}finally{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					LOGGER.error("",e);
				}
			}
		}
	}
	
	public void handler(){
		while(true){
			TimingBean task=queue.getFirstTask();
			if(task==null){
				LOGGER.debug("当前没有任务");
				break;
			}
			
			long timingTime=task.getTimingTime();
			//如果时间还未到，则退出
			if(System.currentTimeMillis()-timingTime<0){
				boolean result=queue.addTask(task);
				if(!result){
					LOGGER.error("插入任务失败1{}",task);
				}
				break;
			}
			LOGGER.info("任务[{}]执行时间已到，放入执行队列",new Object[]{task});
			SimulatorWorkThread.addTask((WorkBean)task);
		}
	}
	
	
	public static void delayTask(TimingBean task,long score){
		task.setTimingTime(System.currentTimeMillis()+score);
		boolean result=queue.addTask(task);
		if(!result){
			LOGGER.error("插入任务失败{}",task);
		}
		LOGGER.info("任务[{}]延迟[{}]毫秒执行",new Object[]{task,score});
	}
	
	public static void delayTask(TimingBean task){
		long score=RandomUtils.getRandomNum(3000)+3000;
		delayTask(task,score);
	}
	
	public static int getQueueSize(){
		return queue.getSize();
	}
	
}
