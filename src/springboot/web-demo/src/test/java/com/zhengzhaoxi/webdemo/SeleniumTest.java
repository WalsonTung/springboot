package com.zhengzhaoxi.webdemo;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.apache.taglibs.standard.lang.jstl.DivideOperator;
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
			survey(loginUrl);
			
			Assert.assertTrue(true);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	/**
	 * 查勘
	 */
	private void survey(String loginUrl) {
		loginUrl = "http://10.190.48.150:7001/systemUse.do?branchCode=5020100&employeeCode=976041&mac=";
		SeleniumHelper helper = SeleniumHelper.getInstance();
		helper.initChromeDriver()
		.get(loginUrl)
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到调度iframe
		.setTextValue(By.cssSelector("div#d_queryForm tr.d-form-layout-row td.first-cell input.editor"), "DSHZ94594619050065")
		.click(By.cssSelector("div.d-toolbar span#d_btnQuery"))
		.doubleClick(By.cssSelector("div#d_dgTaskDetail table.data-table tr.current-row"))
		.switchToDefaultContent()
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到查勘iframe
		.setTextValue(By.cssSelector("div#d_afSurvey table.d-form-layout tr:nth-last-child(1) td.first-cell textarea"), "损失清单：test")//填写查勘情况
		.click(By.cssSelector("div#d_afAccident table.d-form-layout tr:nth-last-child(1) td.first-cell div.d-trigger"))//选择全责
		.click(By.cssSelector("body>div:nth-last-child(1) table.data-table tr:nth-last-child(1) td"))//
		.click(By.cssSelector("div#d_viewMain div.d-toolbar span#d_btnImage"))//点击影像按钮
		;
		
	}
	
	/**
	 * 调度
	 * @param loginUrl
	 */
	private void dispatch(String loginUrl) {
		SeleniumHelper helper = SeleniumHelper.getInstance();
		helper.initChromeDriver()
		.get(loginUrl)
		.click(By.id("d__uid_96"))//理赔管理
		.click(By.cssSelector("div#d_claim li:nth-child(4)"))//调度
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到调度iframe
		.waitToShow(By.cssSelector("div#d_viewMain div#d_afQuery"))//等待加载调度查询页面
		.setTextValue(By.cssSelector("div#d__uid_23 input.editor"), "DSHZ10794619600000")//填写报案号
		.click(By.cssSelector("div#d_barQuery span#d_btnQuery"))
		.doubleClick(By.cssSelector("div#d_dgDispatch table.data-table tbody tr:nth-child(1)"))
		.switchToDefaultContent()
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到调度详情iframe
		.waitToShow(By.cssSelector("div#d_viewMain"))//等待加载调度查询页面
		.click(By.cssSelector("div#d_dgDispatchInf table.header-table div.d-icon-button"))//新增查勘
		.click(By.cssSelector("div#d_dgDispatchInf table.header-table div.d-icon-button"))//新增定损
		.click(By.cssSelector("div#d_dgDispatchInf table.data-table tr:nth-last-child(2) td:nth-child(3) div.cell"))//查勘
		.click(By.cssSelector("div#d_dgDispatchInf div.d-grid-cell-editor div.d-trigger"))//弹出下拉列表
		.click(By.cssSelector("body>div:nth-last-child(1) table.data-table tr:nth-last-child(2) td"))//
		.click(By.cssSelector("div#d_dgDispatchInf table.data-table tr:nth-last-child(2) td:nth-child(6)"))//本司
		.click(By.cssSelector("div#d_dgDispatchInf div.d-grid-cell-editor div.d-trigger"))//弹出下拉列表
		.click(By.cssSelector("body>div:nth-last-child(1) table.data-table tr:nth-child(1) td"))//
		.click(By.cssSelector("div#d_dgDispatchInf table.data-table tr:nth-last-child(2) td:nth-child(8)"))//查勘人
		.click(By.cssSelector("div#d_dgDispatchInf div.d-grid-cell-editor div.d-trigger"))//弹出对话框
		.switchToFrame(By.cssSelector("body>div#d_dlgcompletePersonName div#d_iFrameEmploye iframe"))//
		.setTextValue(By.cssSelector("div#d_autoFormQueryEntity table.d-form-layout tr.d-form-layout-row  td:nth-last-child(1) input.editor"), "詹青晓")//
		.click(By.cssSelector("div.d-toolbar span#d_btnSearch"))
		.doubleClick(By.cssSelector("div#d_dataGridUsers table.data-table tr.current-row"))
		.switchToParentFrame()
		.click(By.cssSelector("div#d_dgDispatchInf table.data-table tr:nth-last-child(1) td:nth-child(3) div.cell"))//定损
		.click(By.cssSelector("div#d_dgDispatchInf div.d-grid-cell-editor div.d-trigger"))//弹出下拉列表
		.click(By.cssSelector("body>div:nth-last-child(1) table.data-table tr:nth-last-child(1) td"))//
		.click(By.cssSelector("div#d_dgDispatchInf table.data-table tr:nth-last-child(1) td:nth-child(6)"))//本司
		.click(By.cssSelector("div#d_dgDispatchInf div.d-grid-cell-editor div.d-trigger"))//弹出下拉列表
		.click(By.cssSelector("body>div:nth-last-child(1) table.data-table tr:nth-child(1) td"))//
		.click(By.cssSelector("div#d_dgDispatchInf table.data-table tr:nth-last-child(1) td:nth-child(8)"))//定损人
		.click(By.cssSelector("div#d_dgDispatchInf div.d-grid-cell-editor div.d-trigger"))//弹出对话框
		.switchToFrame(By.cssSelector("body>div#d_dlgcompletePersonName div#d_iFrameEmploye iframe"))//
		.setTextValue(By.cssSelector("div#d_autoFormQueryEntity table.d-form-layout tr.d-form-layout-row  td:nth-last-child(1) input.editor"), "詹青晓")//
		.click(By.cssSelector("div.d-toolbar span#d_btnSearch"))
		.doubleClick(By.cssSelector("div#d_dataGridUsers table.data-table tr.current-row"))
		.switchToParentFrame()
		//.click(By.cssSelector("div.d-toolbar span#d_btn_submit"))//提交
		.switchToDefaultContent()
		.click(By.cssSelector("div#d_tabset>div.d-tabbar ul.tabs li.tab-selected span.close"))//关闭页签
		.click(By.cssSelector("div#d_tabset>div.d-tabbar ul.tabs li.tab-selected span.close"))//关闭页签
		;
	}
	/**
	 * 报案
	 * @param loginUrl
	 */
	private void reportCase(String loginUrl) {
		SeleniumHelper helper = SeleniumHelper.getInstance();
		helper.initChromeDriver()
		.get(loginUrl)
		.click(By.id("d__uid_96"))//理赔管理
		.click(By.cssSelector("div#d_claim li:nth-child(2)"))//报案
		.switchToFrame(By.cssSelector("div#d__uid_198>iframe"))//切换到报案iframe
		.waitToShow(By.cssSelector("div#d_viewMain div#d_afAccident"))//等待加载报案页面
		.setTextValue(By.cssSelector("div#d_reportorNameAF input.editor"), "张先生")//填写报案人
		.setTextValue(By.cssSelector("div#d__uid_37 input"), "13723746460")//手机
		.setTextValue(By.cssSelector("div#d__uid_39 input.editor"), "")//联系电话
		.click(By.cssSelector("div#d__uid_47 div.d-trigger"))//联系地址
		.click(By.cssSelector("div#d_dtArea tbody tr:nth-child(1) td.d-tree-node"))
		.click(By.xpath("//div[@id='d_dtArea']//tr/td//label[contains(text(),'河北省')]"))
		.click(By.xpath("//div[@id='d_dtArea']//tr/td//label[contains(text(),'石家庄市')]"))
		.click(By.xpath("//div[@id='d_dtArea']//tr/td//label[contains(text(),'长安区')]"))
		.click(By.xpath("//div[@id='d_dtArea']//tr/td//label[contains(text(),'建北街道')]"))
		.doubleClick(By.xpath("//div[@id='d_dtArea']//tr/td//label[contains(text(),'光华路社区')]"))
		.click(By.cssSelector("div#d_dtArea tbody tr td.d-tree-node label:contains('山东省')"))
	//	.setTextValue(By.cssSelector("div#d__uid_47 input.editor"), "")//联系地址
		.setTextValue(By.cssSelector("div#d__uid_49 input.editor"), "安徽省六安市霍邱县宋店乡")//具体地址
		.setTextValue(By.cssSelector("div#d__uid_68 input.editor"), "2019-05-21 17:00:00",true)//出险时间
		.click(By.cssSelector("div#d__uid_70 div.d-trigger"))//出险地址
	//	.setTextValue(By.cssSelector("div#d__uid_70 input.editor"), "")//出险地址
	//	.setTextValue(By.cssSelector("div#d__uid_72 input.editor"), "安徽省六安市霍邱县宋店乡",true)//具体地址d__uid_75
		.click(By.cssSelector("div#d__uid_75 div.d-trigger"))//选择出险原因
		.click(By.cssSelector("div#d_dtAccident tr:nth-child(2) td.d-tree-node"))
		.click(By.cssSelector("div#d_dtAccident tr:nth-child(5) td.d-tree-node"))
		.doubleClick(By.cssSelector("div#d_dtAccident tr:nth-child(8) td"))
		.setTextValue(By.cssSelector("div#d__uid_85 textarea"), "拖拉机在作业过程中不小心压倒石子，弹起来导致旁边的小车天窗有受损，估损2000")//事故经过
		.click(By.cssSelector("div#d__uid_101 div.d-trigger"))//选择保单
		.setTextValue(By.cssSelector("div#d_dlg_PolicyQuery div#d__uid_150 input.editor"), "ASHZALL94619Q600002Z")
		.click(By.cssSelector("div#d_dlg_PolicyQuery span#d_btnQuery"))
		.click(By.cssSelector("div#d_dgReportPolicy table.data-table tbody tr:nth-child(1) span.d-checkbox"))
		.click(By.cssSelector("div#d_dlg_PolicyQuery span#d_btn_returnValue"))
		.setTextValue(By.cssSelector("div#d__uid_111 input.editor"), "1")//损失数量
		.setTextValue(By.cssSelector("div#d__uid_121 input.editor"), "1")//受损户数
		.click(By.cssSelector("div#d_viewMain div#d_toolBar span#d_btn_Submit"))//提交
		.switchToDefaultContent()
		//.click(By.cssSelector("div#d_tabset>div.d-tabbar ul.tabs li.tab-selected span.close"))//关闭页签
		;
	}
}
