package com.zhengzhaoxi.webdemo.core;

import java.lang.reflect.Type;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtils {

	private JsonUtils(){}
	
	public static String toJson(Object entity) {

		return toJson(entity,"yyyy-MM-dd HH:mm:ss");
	}
	
	public static String toJson(Object entity,String dateFormat) {
		return JSON.toJSONStringWithDateFormat(entity,dateFormat,SerializerFeature.WriteMapNullValue);
	}

	public static <T> T fromJson(String json, Class<T> clazz) {

		return JSON.parseObject(json, clazz);
	}
	
	public static <T> T fromJson(String json, Type type) {
		return JSON.parseObject(json, type);
	}
	
	public static <T> List<T> parseArray(String json,Class<T> clazz){
		return JSON.parseArray(json, clazz);
	}
	
}
