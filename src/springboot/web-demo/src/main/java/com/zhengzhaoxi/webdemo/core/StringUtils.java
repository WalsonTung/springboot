package com.zhengzhaoxi.webdemo.core;

import java.util.UUID;

public class StringUtils {

	public static String newUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.trim().equals("");
	}
}
