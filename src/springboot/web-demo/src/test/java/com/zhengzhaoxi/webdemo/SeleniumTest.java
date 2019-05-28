package com.zhengzhaoxi.webdemo;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhengzhaoxi.webdemo.core.DateUtils;
import com.zhengzhaoxi.webdemo.core.SeleniumHelper;
import com.zhengzhaoxi.webdemo.model.NewNongReportCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumTest {
	
	private NewNongReportCase mReportCase = new NewNongReportCase();

	@Test
	public void loginTest() {
		initReportCase();
	//	System.setProperty("webdriver.ie.driver", "F:\\Softwares\\Network\\selenium\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		String loginUrl = "http://10.186.54.132:31001/systemUse.do?branchCode=5020100&employeeCode=999&mac=";
		try {
			getPayment();
			
			Assert.assertTrue(true);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	/**
	 * 获取赔款数据
	 */
	private void getPayment() {
		String loginUrl = "http://10.190.48.150:7001/systemUse.do?branchCode=5020100&employeeCode=434&mac=";
		SeleniumHelper helper = SeleniumHelper.getInstance();
		helper.initChromeDriver()
		.get(loginUrl)
		.click(By.xpath("//div[@id='d_accordion']/div/div/div[contains(text(),'理赔管理')]"))
		.click(By.xpath("//div[@id='d_accordion']//div[@id='d_claim']/ul/li/span/span[contains(text(),'综合查询')]"))
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到我的任务组iframe
		.setTextValue(By.cssSelector("div#d_claimFolderQueryConditionForm tr.first-row td:nth-child(2) input.editor"), mReportCase.getReportCaseNo())
		.click(By.cssSelector("div.d-toolbar span#d_btnQuery"))
		.doubleClick(By.cssSelector("div#d_gridClaimFolderQueryResult table.data-table  tbody tr:nth-child(1)"))
		.switchToDefaultContent()
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到案件详情iframe
		.click(By.cssSelector("div#d_tabControl1 ul.bar-tabs li:nth-last-child(2)"))
		;
		List<WebElement> rows =  helper.getElements(By.cssSelector("div#d_dgPaidRealIncome table.data-table tr.row"));
		String paymentNo = null;
		String payAmount = null;
		String payTime = null;
		for(WebElement row : rows) {
			paymentNo = row.findElement(By.cssSelector("td:nth-child(3) div")).getText();
			payAmount = row.findElement(By.cssSelector("td:nth-child(4) div")).getText();
			payTime = row.findElement(By.cssSelector("td:nth-child(5) div")).getText();
			System.out.println(paymentNo + ";" +payAmount + ";" + payTime );
		}
	}
	
	/**
	 * 06定损
	 */
	private void fixLoss() {
		String loginUrl = "http://10.186.54.132:31001/systemUse.do?branchCode=5020100&employeeCode=1687&mac=";
		SeleniumHelper helper = SeleniumHelper.getInstance();
		helper.initChromeDriver()
		.get(loginUrl)
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到调度iframe
		.setTextValue(By.cssSelector("div#d_queryForm tr.d-form-layout-row td.first-cell input.editor"),mReportCase.getReportCaseNo())
		.click(By.cssSelector("div.d-toolbar span#d_btnQuery"))
		//.doubleClick(By.cssSelector("div#d_dgTaskDetail table.data-table tr.current-row"))
		.doubleClick(By.cssSelector("div#d_dgTaskDetail table.data-table tr:nth-last-child(1)"))
		.switchToDefaultContent()
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到定损iframe
		.click(By.cssSelector("div#d_viewMain div.d-toolbar span#d_btnImage"))//点击影像按钮
		.switchToFrame(By.cssSelector("body>div#d_dlgImage div#d_imageFrame iframe"))
		;
	}
	
	/**
	 * 05复核立案
	 */
	private void reviewCase() {
		String loginUrl = "http://10.186.54.132:31001/systemUse.do?branchCode=5020100&employeeCode=999&mac=";
		SeleniumHelper helper = SeleniumHelper.getInstance();
		helper.initChromeDriver()
		.get(loginUrl)
		.click(By.cssSelector("div#d_accordion>div:nth-child(2)"))//理赔任务
//		.click(By.cssSelector("div#d_claimTask li:nth-child(1)"))//我的任务组
//		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到我的任务组iframe
//		.setTextValue(By.cssSelector("div#d_queryForm tr.first-row td.first-cell input.editor"), mReportCase.getReportCaseNo())
//		.click(By.cssSelector("div.d-toolbar span#d_btnQuery"))
//		.click(By.xpath("//div[@id='d_dbvTask']/div/div/div//td[contains(text(),'组别：立案复核')]"))
//		.doubleClick(By.cssSelector("div#d_dgTaskDetail table.data-table tr:nth-child(1)"))//双击案件
//		.click(By.cssSelector("body>div.d-dialog div.button-panel span.d-button-focused"))//同意接收立案复核任务
//		.switchToDefaultContent()
//		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到立案复核iframe
//		.click(By.cssSelector("div#d_viewMain div.d-toolbar span#d_btn_pass"))
//		.click(By.cssSelector("body>div.d-dialog div.button-panel span.d-button-focused"))//同意立案
		//以下为我的任务入口
		.click(By.cssSelector("div#d_claimTask li:nth-child(2)"))//我的任务
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到立案复核iframe
		.setTextValue(By.cssSelector("div#d_viewMain div#d_queryForm tr.first-row td.first-cell input.editor"), mReportCase.getReportCaseNo())//填写报案号
		.click(By.cssSelector("div.d-toolbar span#d_btnQuery"))
		.doubleClick(By.cssSelector("div#d_dgTaskDetail table.data-table tbody tr:nth-child(1)"))
		.switchToDefaultContent()
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到立案详情iframe
		.click(By.cssSelector("div#d_viewMain div.d-toolbar span#d_btn_pass"))
		.click(By.cssSelector("body>div.d-dialog div.button-panel span.d-button-focused"))//同意立案
        ;
	
	}
	
	/**
	 * 04立案
	 */
	private void registerCase() {
        String loginUrl = "http://10.186.54.132:31001/systemUse.do?branchCode=5020100&employeeCode=1687&mac=";
		
		SeleniumHelper helper = SeleniumHelper.getInstance();
		helper.initChromeDriver()
		.get(loginUrl)
		.click(By.cssSelector("div#d_accordion>div:nth-child(2)"))//理赔管理
		.click(By.cssSelector("div#d_claim li:nth-child(5)"))//调度
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到调度iframe
		.waitToShow(By.cssSelector("div#d_viewMain div#d_afQuery tr.first-row"))//等待加载调度查询页面
		.setTextValue(By.cssSelector("div#d_viewMain div#d_afQuery tr.first-row td:nth-last-child(1) input.editor"), mReportCase.getReportCaseNo())//填写报案号
		.click(By.cssSelector("div#d_barQuery span#d_btnQuery"))
		.doubleClick(By.cssSelector("div#d_dgClaim table.data-table tbody tr:nth-child(1)"))
		.switchToDefaultContent()
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到立案详情iframe
		.click(By.cssSelector("body>div.d-dialog div.button-panel>span:nth-child(1)"))//关闭对话框
		.setTextValue(By.cssSelector("div#d_afEstimateInfoList input.editor"), mReportCase.getTotalEstimatedLossAmount().toString())//总估损
		.scrollTo(By.cssSelector("div#d__uid_30"), 500)
		.setTextValue(By.cssSelector("div#d_afPolicy tbody>tr:nth-child(3)>td:nth-child(4) input.editor"), mReportCase.getLossAmount().toString())//损失金额
	//	.click(By.cssSelector("div.d-toolbar span#d_btn_act"))//提交
		;
	//	boolean success = helper.hasElement(By.cssSelector("body>div:d-dialog-focused div.dialog-body div.msg-content span:contains('提交成功')"));
	//	System.out.print(success);
	//	helper.switchToDefaultContent()
		//	.click(By.cssSelector("div#d_tabset>div.d-tabbar ul.tabs li.tab-selected span.close"))//关闭页签
		;
	}
	
	/**
	 * 03查勘
	 */
	private void survey() {
		String loginUrl = "http://10.186.54.132:31001/systemUse.do?branchCode=5020100&employeeCode=1687&mac=";
		
		String noSurveyReason = "因出险远在异地，且损失较小、损失项目明确、单一，已指引被保险人现场拍照，故未进行现场查勘，未能提交查勘记录及查勘工作底稿。";
		SeleniumHelper helper = SeleniumHelper.getInstance();
		helper.initChromeDriver()
		.get(loginUrl)
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到调度iframe
		.setTextValue(By.cssSelector("div#d_queryForm tr.d-form-layout-row td.first-cell input.editor"),mReportCase.getReportCaseNo())
		.click(By.cssSelector("div.d-toolbar span#d_btnQuery"))
		//.doubleClick(By.cssSelector("div#d_dgTaskDetail table.data-table tr.current-row"))
		.doubleClick(By.cssSelector("div#d_dgTaskDetail table.data-table tr:nth-last-child(1)"))
		.switchToDefaultContent()
		.switchToFrame(By.cssSelector("div.d-iframe[style*='display: block;']>iframe"))//切换到查勘iframe
		.setTextValue(By.cssSelector("div#d_afSurvey table.d-form-layout tr:nth-last-child(1) td.first-cell textarea"), "损失清单：test")//填写查勘情况
		.click(By.cssSelector("div#d_afAccident table.d-form-layout tr:nth-last-child(1) td.first-cell div.d-trigger"))//选择全责
		.click(By.cssSelector("body>div:nth-last-child(1) table.data-table tr:nth-last-child(1) td"))//
		.click(By.cssSelector("div#d_viewMain div.d-toolbar span#d_btnImage"))//点击影像按钮
		.switchToFrame(By.cssSelector("body>div#d_dlgImage div#d_imageFrame iframe"))
	//	.click(By.cssSelector("div#d_view span#d_btnImageSubmit"))//打开文件系统
		.switchToParentFrame()
		.click(By.cssSelector("div#d_viewMain div.d-toolbar span#d_btnImage"))//点击影像按钮
		.switchToFrame(By.cssSelector("body>div#d_dlgImage div#d_imageFrame iframe"))
		.click(By.cssSelector("div#d_imageForm div#d_opResultNameAFE div.d-trigger"))//填写未现场查勘原因 (点击无反应，需要多测试)
		.click(By.cssSelector("body>div:nth-last-child(1) table.data-table tbody>tr:nth-last-child(1) td"))//选择影像缺失
		.setTextValue(By.cssSelector("div#d_imageForm div#d_memoAFE textarea"),noSurveyReason)
		.click(By.cssSelector("div#d_view span#d_btnImageSubmit"))
		.switchToParentFrame()
		.click(By.cssSelector("div.d-toolbar span#d_btn_submit"))//提交
		;
		boolean success = helper.hasElement(By.cssSelector("body>div:d-dialog-focused div.dialog-body div.msg-content span:contains('提交成功')"));
		helper.switchToDefaultContent()
		//	.click(By.cssSelector("div#d_tabset>div.d-tabbar ul.tabs li.tab-selected span.close"))//关闭页签
		;
	}
	
	/**
	 *02 调度
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
		.setTextValue(By.cssSelector("div#d__uid_23 input.editor"), mReportCase.getReportCaseNo())//填写报案号
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
		.click(By.cssSelector("div.d-toolbar span#d_btn_submit"))//提交
		;
		boolean success = helper.hasElement(By.cssSelector("body>div:d-dialog-focused div.dialog-body div.msg-content span:contains('提交成功')"));
		
		helper.switchToDefaultContent()
	//	.click(By.cssSelector("div#d_tabset>div.d-tabbar ul.tabs li.tab-selected span.close"))//关闭页签
	//	.click(By.cssSelector("div#d_tabset>div.d-tabbar ul.tabs li.tab-selected span.close"))//关闭页签
		;
	}
	/**
	 * 01报案
	 * @param loginUrl
	 */
	private void reportCase(String loginUrl) {
		
		initReportCase();
		
		SeleniumHelper helper = SeleniumHelper.getInstance();
		helper.initChromeDriver()
		.get(loginUrl)
		.click(By.id("d__uid_96"))//理赔管理
		.click(By.cssSelector("div#d_claim li:nth-child(2)"))//报案
		.switchToFrame(By.cssSelector("div#d__uid_198>iframe"))//切换到报案iframe
		.waitToShow(By.cssSelector("div#d_viewMain div#d_afAccident"))//等待加载报案页面
		.setTextValue(By.cssSelector("div#d_reportorNameAF input.editor"), mReportCase.getReporterName())//填写报案人
		.setTextValue(By.cssSelector("div#d__uid_37 input"), mReportCase.getReportPhoneNo())//手机
	//	.setTextValue(By.cssSelector("div#d__uid_39 input.editor"), "")//联系电话
		.click(By.cssSelector("div#d__uid_47 div.d-trigger"))//联系地址
		.click(By.cssSelector("div#d_dtArea tbody tr:nth-child(1) td.d-tree-node"))
		.click(By.xpath("//div[@id='d_dtArea']//tr/td//label[contains(text(),'河北省')]"))
		.click(By.xpath("//div[@id='d_dtArea']//tr/td//label[contains(text(),'石家庄市')]"))
		.click(By.xpath("//div[@id='d_dtArea']//tr/td//label[contains(text(),'长安区')]"))
		.click(By.xpath("//div[@id='d_dtArea']//tr/td//label[contains(text(),'建北街道')]"))
		.doubleClick(By.xpath("//div[@id='d_dtArea']//tr/td//label[contains(text(),'光华路社区')]"))
		.setTextValue(By.cssSelector("div#d__uid_49 input.editor"), mReportCase.getContactDetailsAddress())//具体地址
		.setTextValue(By.cssSelector("div#d__uid_68 input.editor"),DateUtils.toDateTimeString( mReportCase.getLossEventTime()),true)//出险时间
		.click(By.cssSelector("div#d__uid_70 div.d-trigger"))//出险地址
		.setTextValue(By.cssSelector("div#d__uid_72 input.editor"), mReportCase.getLossEventDetailsPlace(),true)//具体地址d__uid_75
		.click(By.cssSelector("div#d__uid_75 div.d-trigger"))//选择出险原因
		.click(By.cssSelector("div#d_dtAccident tr:nth-child(2) td.d-tree-node"))
		.click(By.cssSelector("div#d_dtAccident tr:nth-child(5) td.d-tree-node"))
		.doubleClick(By.cssSelector("div#d_dtAccident tr:nth-child(8) td"))
		.setTextValue(By.cssSelector("div#d__uid_85 textarea"), mReportCase.getCaseDescription())//事故经过
		.click(By.cssSelector("div#d__uid_101 div.d-trigger"))//选择保单
		.setTextValue(By.cssSelector("div#d_dlg_PolicyQuery div#d__uid_150 input.editor"), mReportCase.getPolicyNo())
		.click(By.cssSelector("div#d_dlg_PolicyQuery span#d_btnQuery"))
		.click(By.cssSelector("div#d_dgReportPolicy table.data-table tbody tr:nth-child(1) span.d-checkbox"))
		.click(By.cssSelector("div#d_dlg_PolicyQuery span#d_btn_returnValue"))
		.setTextValue(By.cssSelector("div#d__uid_111 input.editor"), mReportCase.getLossCount().toString())//损失数量
		.setTextValue(By.cssSelector("div#d__uid_121 input.editor"), mReportCase.getLossNumberOfHouseholds().toString())//受损户数
		.click(By.cssSelector("div#d_viewMain div#d_toolBar span#d_btn_Submit"))//提交
		;
		mReportCase.setReportCaseNo("");//获取报案号
		helper.switchToDefaultContent()
		//.click(By.cssSelector("div#d_tabset>div.d-tabbar ul.tabs li.tab-selected span.close"))//关闭页签
		;
	}
	
	private void initReportCase() {
		mReportCase = new NewNongReportCase();
		mReportCase.setPolicyNo("ASHZALL94619Q600002Z");
		mReportCase.setCaseDescription("无人机起飞之后失控撞到树 估损不详");
		mReportCase.setContactAddress("河北省>石家庄市>长安区>建北街道>光华路社区");
		mReportCase.setContactDetailsAddress("什么村门牌号");
		mReportCase.setHaveThirdParty(true);
		mReportCase.setLossEventDetailsPlace("河北省>石家庄市>长安区>建北街道>光华路社区");
		mReportCase.setLossEventDetailsPlace("什么村");
		mReportCase.setRemark("备注");
		mReportCase.setReporterName("王先生");
		mReportCase.setReportPhoneNo("13723746460");
		mReportCase.setThirdPartyInjury("张先生");
		mReportCase.setThirdPartyProperty("一头猪");
		mReportCase.setThirdPartyPropertyOwner("李先生");
		mReportCase.setReportCaseNo("DSHZ94599118000009");
		mReportCase.setLossAmount(1000.0);
		mReportCase.setTotalEstimatedLossAmount(900.0);
	}
}
