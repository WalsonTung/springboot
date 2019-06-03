package com.zhengzhaoxi.webdemo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhengzhaoxi.webdemo.core.HttpClient;
import com.zhengzhaoxi.webdemo.core.JsonUtils;
import com.zhengzhaoxi.webdemo.core.StringUtils;
import com.zhengzhaoxi.webdemo.model.DtsNongReportCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DtsNongReportCaseTest {

	@Test
	public void testPostNongReportCase() {
		DtsNongReportCase reportCase = new DtsNongReportCase();
		reportCase.setOrderNo(StringUtils.newUuid());
		reportCase.setCaseDescription("农机翻车");
		reportCase.setLossEventPlace("村口");
		reportCase.setLossEventTime(new Date());
		reportCase.setPolicyNo("ASHZ06702416Q000047J");

		reportCase.setReporterPhoneNumber("13723746460");
		reportCase.setReporterName("xin");
		List<DtsNongReportCase> list = new ArrayList<DtsNongReportCase>();
		list.add(reportCase);
		String data =  JsonUtils.toJson(list);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("serviceAccount", "nongclaim");
		map.put("data", data);
		try {
			HttpClient.setWebProxy(true);
			String requestUrl = "http://api.cxshz.test.cpic.com.cn/ods/dts/saveNongClaimReportCases";
			String result = HttpClient.newInstance().createRequest(requestUrl).postJson(map);
		    System.out.print(result);
			Assert.assertTrue(result.contains("000000"));
		}  catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(e.getMessage(), true);
		}
		
	}
	
	
	public void testListNongReportCaseReplies() {
		List<String> orderNoList = new ArrayList<String>();
		orderNoList.add("cf5c17326e0c407b8ccda70d56c82ca1");
		String data =  JsonUtils.toJson(orderNoList);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("serviceAccount", "test");
		map.put("data", data);
		try {
			String requestUrl = "http://10.74.0.217:8080/ods/dts/listNongClaimReportCaseReplies";
			String result = HttpClient.newInstance().createRequest(requestUrl).postJson(map);
		    System.out.print(result);
			Assert.assertTrue(result.contains("000001"));
		}  catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(e.getMessage(), true);
		}
	}
	
	public void testListNongPayments() {
		List<String> list = new ArrayList<String>();
		list.add("DSHZ94594619050055");
		String data =  JsonUtils.toJson(list);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("serviceAccount", "test");
		map.put("data", data);
		try {
			String requestUrl = "http://10.74.0.217:8080/ods/dts/listNongClaimPayments";
			String result = HttpClient.newInstance().createRequest(requestUrl).postJson(map);
		    System.out.print(result);
			Assert.assertTrue(result.contains("000000"));
		}  catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(e.getMessage(), true);
		}
	}
	
	public void testUpdateFile() {
		File file = new File("D:\\test.jpg");
		if(!file.exists()) {
			return;
		}
		try {
		
			
			
			HashMap<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("orderNo", "cf5c17326e0c407b8ccda70d56c82ca1");
			
			Map<String, String> fileMap = new HashMap<String, String>();
			fileMap.put("uploadFile", file.getAbsolutePath());
			String requestUrl = "http://10.74.0.217:8080/ods/dts/uploadNongClaimFile";
			String result = HttpClient.newInstance().createRequest(requestUrl).formUpload(paramMap,fileMap);
			 System.out.print(result);
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	
}
