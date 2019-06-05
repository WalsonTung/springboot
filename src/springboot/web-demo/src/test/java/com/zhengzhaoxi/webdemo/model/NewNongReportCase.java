package com.zhengzhaoxi.webdemo.model;

import java.math.BigDecimal;
import java.util.Date;

public class NewNongReportCase extends DtsNongReportCase {

	private static final long serialVersionUID = 1L;
	
	public NewNongReportCase() {
		super();
		lossCount = 1;
		lossNumberOfHouseholds = 1;
		setLossEventTime(new Date());
	}

	public java.lang.String reportCaseNo;

	public java.util.Date reportTime;

	public java.lang.String surveyDescription;

	public java.math.BigDecimal fixedLossAmount;

	public java.lang.Boolean containsThirdParty;

	public java.lang.String caseStatus;

	public java.util.Date createTime;

	
	private Integer lossCount;
	
	private Integer lossNumberOfHouseholds;


	public Integer getLossCount() {
		return lossCount;
	}

	public Integer getLossNumberOfHouseholds() {
		return lossNumberOfHouseholds;
	}

	public void setLossCount(Integer lossCount) {
		this.lossCount = lossCount;
	}

	public void setLossNumberOfHouseholds(Integer lossNumberOfHouseholds) {
		this.lossNumberOfHouseholds = lossNumberOfHouseholds;
	}

	public String getReportCaseNo() {
		return reportCaseNo;
	}

	public void setReportCaseNo(String reportCaseNo) {
		this.reportCaseNo = reportCaseNo;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getSurveyDescription() {
		return surveyDescription;
	}

	public void setSurveyDescription(String surveyDescription) {
		this.surveyDescription = surveyDescription;
	}

	public BigDecimal getFixedLossAmount() {
		return fixedLossAmount;
	}

	public void setFixedLossAmount(BigDecimal fixedLossAmount) {
		this.fixedLossAmount = fixedLossAmount;
	}

	public Boolean getContainsThirdParty() {
		return containsThirdParty;
	}

	public void setContainsThirdParty(Boolean containsThirdParty) {
		this.containsThirdParty = containsThirdParty;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
