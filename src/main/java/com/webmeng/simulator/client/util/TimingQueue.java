package com.webmeng.simulator.client.util;

import java.util.concurrent.ConcurrentSkipListSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定时集合
 * 
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class TimingQueue<T extends Comparable<T>> {
	public static final Logger LOGGER = LoggerFactory.getLogger(TimingQueue.class);

	private ConcurrentSkipListSet<T> list = new ConcurrentSkipListSet<T>();

	public boolean addTask(T task) {
		return list.add(task);
	}

	public T getFirstTask() {
		return list.pollFirst();
	}
	
	public int getSize() {
		return list.size();
	}

}
