package com.webmeng.simulator.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropertiesUtil {

	private static Properties pros = new Properties();
	static {
		InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			pros.load(input);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return pros.getProperty(key);
	}

	public static String getValue(String key, String defaultValue) {
		return (String) pros.getProperty(key, defaultValue);
	}
	
	public static int getInt(String key,int defaultValue){
	    String value=pros.getProperty(key);
	    if(StringUtils.isNotBlank(value)&&StringUtils.isNumeric(value)){
	        return Integer.valueOf(value);
	    }
	    return defaultValue;
	}
	
	public static boolean getBoolean(String key,boolean defaultValue){
	    String value=pros.getProperty(key);
	    if(StringUtils.isBlank(value)){
	        return defaultValue;
	    }
        Boolean flag=Boolean.valueOf(value);
        if(flag==null)
        {
            return defaultValue;
        }
        return flag;
	}
}
