package com.zhengzhaoxi.webdemo.model;

import java.util.Date;

public class NewNongReportCase extends DtsNongReportCase {

	private static final long serialVersionUID = 1L;
	
	public NewNongReportCase() {
		super();
		lossCount = 1;
		lossNumberOfHouseholds = 1;
		setLossEventTime(new Date());
	}

	private String reportPhoneNo;
	
	private String contactAddress;
	
	private String contactDetailsAddress;
	
	private String lossEventDetailsPlace;
	
	private Integer lossCount;
	
	private Integer lossNumberOfHouseholds;
	
	private String reportCaseNo;
	
	private Double lossAmount;
	
	private Double totalEstimatedLossAmount;
	

	public String getReportPhoneNo() {
		return reportPhoneNo;
	}

	public void setReportPhoneNo(String reportPhoneNo) {
		this.reportPhoneNo = reportPhoneNo;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public String getContactDetailsAddress() {
		return contactDetailsAddress;
	}

	public String getLossEventDetailsPlace() {
		return lossEventDetailsPlace;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public void setContactDetailsAddress(String contactDetailsAddress) {
		this.contactDetailsAddress = contactDetailsAddress;
	}

	public void setLossEventDetailsPlace(String lossEventDetailsPlace) {
		this.lossEventDetailsPlace = lossEventDetailsPlace;
	}

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

	public Double getLossAmount() {
		return lossAmount;
	}

	public Double getTotalEstimatedLossAmount() {
		return totalEstimatedLossAmount;
	}

	public void setLossAmount(Double lossAmount) {
		this.lossAmount = lossAmount;
	}

	public void setTotalEstimatedLossAmount(Double totalEstimatedLossAmount) {
		this.totalEstimatedLossAmount = totalEstimatedLossAmount;
	}
}
