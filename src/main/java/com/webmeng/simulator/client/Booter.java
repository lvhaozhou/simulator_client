/**
 * @(#)Booter.java 2017年12月29日
 * Copyright(C) 2017年12月29日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class Booter {
	public static final Logger LOGGER = LoggerFactory.getLogger(Booter.class);

	public static void main(String[] args) {
		int length=1;
		if(args.length>0){
			length=Integer.valueOf(args[0]);
		}
		String host="127.0.0.1";
//		String host="172.18.245.156";
		int port=15001;
		if(args.length>2){
			host=args[1];
			port=Integer.valueOf(args[2]);
		}
		
		Thread thread=new Thread(new SimulatorWorkThread());
    	thread.setDaemon(true);
    	thread.start();
    	
    	Thread timing=new Thread(new TimingThead());
    	timing.setDaemon(true);
    	timing.start();
		
    	final String hostF=host;
    	final int portF=port;
		for(int i=0;i<length;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						SimulatorNewClient.start(hostF,portF);
					}
					
				}
			}).start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				LOGGER.error("",e);
			}
		}
	}
}
