package com.webmeng.simulator.client.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class MathUtils {
	private final static AtomicLong count = new AtomicLong();
	
	public static String getRandomString(int i, String netWorkNum){
		String ret = netWorkNum + getRandomString(i);
		return ret.substring(0, i);
	}
	
  /**
   * 获取指定长度的随即字符串
   * 
   * @param i
   * @return
   */
  public static String getRandomString(int i) {
    String ret = "";
    if (i == 0) {
      return ret;
    }
    Random random = new Random();
    int count = 0;
    while (true) {
      if (i - 10 > 0) {
        i -= 10;
        count = 10;
        ret += getRandomString(random, count);
      } else {
        count = i;
        ret += getRandomString(random, count);
        break;
      }
    }
    return ret;
  }

  /**
   * 
   * @param random
   * @param count
   * @return
   */
  private static String getRandomString(Random random, int count) {
    int max = (int) Math.pow(10, count) - 1;
    int min = (int) Math.pow(10, count - 1);
    return random.nextInt(max) % (max - min + 1) + min + "";
  }
  
  /**
   * 获取订单号
   * @param serverNum 服务器编号
   * @param length 订单号长度
   * @return
   */
  public  static String getUniqueLinkid(String serverNum, int length) {
      while (serverNum.length() < 2) {
          serverNum = "0" + serverNum;
      }
      String uniqueNum = count.incrementAndGet() + "";
      while (uniqueNum.length() < length) {
          uniqueNum = "0" + uniqueNum;
      }
      uniqueNum = uniqueNum.substring(0, length);
      String linkid = serverNum  + uniqueNum;
      return linkid;
  }
  
  /**
   * 获取订单号
   * @param serverNum 服务器编号
   * @param length 订单号长度
   * @return
   */
  public  static String getUniqueLinkid2(String serverNum, int length) {
	  String date = new SimpleDateFormat("HHmmss").format(new Date());
	  String linkId = serverNum + date + getRandomString(length);
      return linkId;
  }
 /* 
  public static void main(String[] args) {
	  final Set<String> setList = new HashSet<String>();
	  
	Runnable runable = new Runnable() {
		
		@Override
		public void run() {
			if(setList.add(getUniqueLinkid("00", 14))){
				System.out.println("error");
			}
		}
	};
	
	ExecutorService executor = Executors.newScheduledThreadPool(100);
	for(int i=0;i<1000000000;i++){
		executor.submit(runable);
		System.out.println("i:" + i);
	}
  }*/
}
