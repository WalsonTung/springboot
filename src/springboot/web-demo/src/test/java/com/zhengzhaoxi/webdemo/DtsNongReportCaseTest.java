package com.zhengzhaoxi.webdemo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.zhengzhaoxi.webdemo.core.RSAUtils;
import com.zhengzhaoxi.webdemo.model.DtsNongThirdInjuredPersonPojo;
import com.zhengzhaoxi.webdemo.model.DtsNongThirdPartyLossPojo;
import com.zhengzhaoxi.webdemo.model.NongSurveyInfo;
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

	private final static String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDAFaT5aVGH1QFsb5Uvr3jpGFGYRZYu/Ze6D8dL0kYxuVDxrxCFTqdMkdZFfmGD5x8OCXI+aq4qJKqAtlg2wamOUkB6jxbMGkfaYdFxqLPNpSzkhX0Tp3IH30rY8lMLNkS9Wcr+w6keK8V56FiyKYbpsIRbzNVTfQ3Z1etAoe+7ZwIDAQAB";

	@Test
	public void testPostNongReportCase() {
		DtsNongReportCase reportCase = new DtsNongReportCase();
		reportCase.setOrderNo(StringUtils.newUuid());
		reportCase.setCaseDescription("农机翻车，机器有损伤，需要维修");
		reportCase.setLossEventPlace("土山寨南地柳大树边");
		reportCase.setLossEventTime(new Date());
		reportCase.setPolicyNo("ASHZALL94619Q600002Z");

		reportCase.setReporterPhoneNumber("13723746460");
		reportCase.setReporterName("董怀信");
		reportCase.setReporterAddress("深圳市福田区莲花社区深业上城58楼");
		reportCase.setTotalEstimatedLossAmount(BigDecimal.valueOf(2000.0));
		List<DtsNongReportCase> list = new ArrayList<DtsNongReportCase>();
		list.add(reportCase);
		String data =  JsonUtils.toJson(list);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("serviceAccount", "nongclaim");
		try {
			String encryptData = RSAUtils.encryptByPublicKey(data,PUBLIC_KEY);
			map.put("data", encryptData);
			//HttpClient.setWebProxy(true);
			String requestUrl = "http://10.182.102.98:1703/ods/dts/saveNongClaimReportCases";
			String result = HttpClient.newInstance().createRequest(requestUrl).postJson(map);
		    System.out.print(result);
			Assert.assertTrue(result.contains("000000"));
		}  catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(e.getMessage(), true);
		}
		
	}



	public void testSaveSurveyInfo(){
		DtsNongThirdInjuredPersonPojo injuredPerson = new DtsNongThirdInjuredPersonPojo();
		injuredPerson.setInjuredPersonIdNo("412428198911217619");
		injuredPerson.setInjuredPersonName("董信");
		injuredPerson.setRemark("轻微挂伤.");
		List<DtsNongThirdInjuredPersonPojo> injuredPersons = new ArrayList<>();
		injuredPersons.add(injuredPerson);

		DtsNongThirdPartyLossPojo thirdPartyLoss = new DtsNongThirdPartyLossPojo();
		thirdPartyLoss.setThirdPropertyName("一条狗");
		thirdPartyLoss.setThirdPropertyOwner("王二");
		thirdPartyLoss.setThirdPropertyOwnerIdNo("4346846199304124685");
		thirdPartyLoss.setRemark("狗重伤，需要去医院治疗.");
		List<DtsNongThirdPartyLossPojo> thirdPartyLosses = new ArrayList<>();
		thirdPartyLosses.add(thirdPartyLoss);

		NongSurveyInfo surveyInfo = new NongSurveyInfo();
		surveyInfo.setOrderNo("032e330e1ee64e659d426f2bd87981c7");
		surveyInfo.setReportCaseNo("DSHZ10794619600002");
		surveyInfo.setSurveyDescription("查勘情况：撞轻伤一人，重伤一条狗");
		surveyInfo.setContainsThirdParty(true);
		surveyInfo.setFixedLossAmount(BigDecimal.valueOf(900.0));
		surveyInfo.setThirdInjuredPersonList(injuredPersons);
		surveyInfo.setThirdPartyLossList(thirdPartyLosses);

		List<NongSurveyInfo> list = new ArrayList<>();
		list.add(surveyInfo);
		String data =  JsonUtils.toJson(list);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("serviceAccount", "nongclaim");

		try {
			String encryptData = RSAUtils.encryptByPublicKey(data,PUBLIC_KEY);
			map.put("data", encryptData);
			//HttpClient.setWebProxy(true);
			String requestUrl = "http://10.74.0.217:8080/ods/dts/saveNongSurveyInfo";
			String result = HttpClient.newInstance().createRequest(requestUrl).postJson(map);
			System.out.print(result);
			Assert.assertTrue(result.contains("000000"));
		}  catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(e.getMessage(), true);
		}
	}
	
}
