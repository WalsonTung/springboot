package com.zhengzhaoxi.webdemo.core;

import java.util.UUID;
import java.util.regex.Pattern;

public class StringUtils {

	public static String newUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.trim().equals("");
	}
	
	public static boolean isMobileNumber(String value) {
		if(StringUtils.isNullOrEmpty(value)) {
			return false;
		}
		Pattern pattern = Pattern.compile( "^[1]([3-9])[0-9]{9}$"); 
	    return pattern.matcher(value).matches();
	}
}
