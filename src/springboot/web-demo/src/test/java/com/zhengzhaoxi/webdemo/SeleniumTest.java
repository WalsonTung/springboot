package com.zhengzhaoxi.webdemo;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhengzhaoxi.webdemo.core.SeleniumHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumTest {

	@Test
	public void loginTest() {
	//	System.setProperty("webdriver.ie.driver", "F:\\Softwares\\Network\\selenium\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		String loginUrl = "http://10.186.54.132:31001/systemUse.do?branchCode=5020100&employeeCode=999&mac=";
		try {
			SeleniumHelper helper = SeleniumHelper.getInstance();
			helper.initChromeDriver()
			.get(loginUrl)
			.click(By.id("d__uid_96"))//理赔管理
			.click(By.cssSelector("div#d_claim li:nth-child(2)"))//报案
			.switchToFrame(By.cssSelector("div#d__uid_198>iframe"))//切换到报案iframe
			.waitToShow(By.cssSelector("div#d_viewMain div#d_afAccident"))//等待加载报案页面
			.setTextValue(By.cssSelector("div#d_reportorNameAF input.editor"), "张先生")//填写报案人
			.setTextValue(By.cssSelector("div#d__uid_37 input"), "13723746460")//手机
			//.setTextValue(By.cssSelector("div#d__uid_39 input.editor"), "")//联系电话
			.setTextValue(By.cssSelector("div#d__uid_47 input.editor"), "")//联系地址
			.setTextValue(By.cssSelector("div#d__uid_49 input.editor"), "安徽省六安市霍邱县宋店乡")//具体地址
			.setTextValue(By.cssSelector("div#d__uid_68 input.editor"), "2019-05-10 17:42:31",true)//出险时间
			.setTextValue(By.cssSelector("div#d__uid_70 input.editor"), "")//出险地址
			.setTextValue(By.cssSelector("div#d__uid_72 input.editor"), "安徽省六安市霍邱县宋店乡",true)//具体地址d__uid_75
			.setTextValue(By.cssSelector("div#d__uid_75 input.editor"), "农机事故")//出险原因
			.setTextValue(By.cssSelector("div#d__uid_85 textarea"), "拖拉机在作业过程中不小心压倒石子，弹起来导致旁边的小车天窗有受损，估损2000")//事故经过
			.setTextValue(By.cssSelector("div#d__uid_101 input.editor"), "ASHZALL94619Q600002Z")//保单号
			;//.click(By.cssSelector("div#d__uid_198 div#d_viewMain span#d_btn_Submit"));//提交
			
			Assert.assertTrue(true);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
}
