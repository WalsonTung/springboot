package com.zhengzhaoxi.webdemo.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import com.zhengzhaoxi.webdemo.core.FileUtils;
import com.zhengzhaoxi.webdemo.core.HttpClient;

public class NongCoreSystemCrawlingService {
	
	private final String CHA_KAN_CODE = "976041";//查勘
	private final String LI_PEI_CODE = "3116";//理赔
	private final String FU_HE_CODE = "434";//复核
	
	private final String BASE_SITE = "http://10.186.54.132:31001";
	
	private final String dataUrl = "http://10.186.54.132:31001/dorado/view-service";
	
	private HttpClient mHttpClient = HttpClient.newInstance();
	
	private boolean login(String employeeCode) {
		String loginUrl = String.format("%ssystemUse.do?branchCode=5020100&employeeCode=%s&mac=", BASE_SITE,employeeCode);
		try {
			mHttpClient.createRequest(loginUrl)
			.get();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean getCheckCodeImage()  {
		 double rand = Math.random();
		 try {
			URL url = new URL("ttp://10.186.54.132:31001/img.do?"+rand);
			File savedFile = new File(String.format("D:\\nongTest\\checkCode\\%s.jpg",rand));
			return FileUtils.downloadImage(url, savedFile);
		} catch ( IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean testLogin() {
		String loginUrl = FileUtils.combinePath(BASE_SITE, "/login.do");
		HashMap<String, String> argsMap = new HashMap<String, String>();
		argsMap.put("userLoginCode", "SHZ999");
		argsMap.put("password", "Pcis@1234");
		argsMap.put("validateImg", "");
		argsMap.put("macAddress", "");
		try {
			String resultJson = mHttpClient.createRequest(loginUrl)
			.post(argsMap);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void reportCase() {
		
	}

}
