/**
 * @(#)Simulator.java 2018年1月11日
 * Copyright(C) 2018年1月11日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webmeng.simulator.client.util.PropertiesUtil;
import com.webmeng.simulator.client.util.RandomUtils;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class Simulator implements Runnable{
	public static final Logger LOGGER = LoggerFactory.getLogger(Simulator.class);

	public static final String TASK_PATH=PropertiesUtil.getValue("task.record.file","E:\\test\\simualtor\\task.txt");
	
	public static final String COUNT_PATH=PropertiesUtil.getValue("task.record.size.file","E:\\test\\simualtor\\task_count.txt");
	
	@Override
	public void run() {
		while(true){
			try{
				doWork();
			}catch(Exception e){
				LOGGER.error("",e);
			}
		}
	}
	
	private void doWork() throws Exception{
//		String task=SimulatorInfoManager.getQueue().take();
//		LOGGER.info("模拟器开始做一个任务");
//		SimulatorInfoManager.setBusy(1);
//		
//		updateFileForTask(TASK_PATH,task);
//		updateFileForCount(COUNT_PATH);
//		long time=RandomUtils.getRandomLongNum(10000)+10000;
//		Thread.sleep(time);
//		LOGGER.info("模拟器开始完成一个任务");
//		SimulatorInfoManager.setBusy(0);
	}
	
	
	private void updateFileForTask(String filePath,String content) throws IOException{
		File taskFile=new File(filePath);
		if(!taskFile.exists()){
			taskFile.createNewFile();
		}
		FileWriter writer=new FileWriter(taskFile,true);
		writer.write(content);
		writer.write("\r\n");
		writer.close();
	}
	
	private void updateFileForCount(String filePath) throws IOException{
		File taskFile=new File(filePath);
		if(!taskFile.exists()){
			taskFile.createNewFile();
		}
		BufferedReader reader=new BufferedReader(new FileReader(taskFile));
		String num=reader.readLine();
		if(StringUtils.isBlank(num)){
			num="0";
		}
		reader.close();
		FileWriter writer=new FileWriter(taskFile,true);
		writer.write((Integer.valueOf(num)+1)+"");
		writer.write("\r\n");
		writer.close();
	}
}
