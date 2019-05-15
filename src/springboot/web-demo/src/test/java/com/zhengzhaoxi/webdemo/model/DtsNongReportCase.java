package com.zhengzhaoxi.webdemo.model;

import java.util.Date;

public class DtsNongReportCase  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
		
	//date formats
	public static final String FORMAT_LOSS_EVENT_TIME = "yyyy-MM-dd";
	public static final String FORMAT_CREATE_TIME = "yyyy-MM-dd";
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * reportCaseId       db_column: report_case_id 
     */ 	
	public java.lang.String reportCaseId;
    /**
     * orderNo       db_column: order_no 
     */ 	
	public java.lang.String orderNo;
    /**
     * policyNo       db_column: policy_no 
     */ 	
	public java.lang.String policyNo;
    /**
     * lossEventTime       db_column: loss_event_time 
     */ 	
	public java.util.Date lossEventTime;
    /**
     * lossEventPlace       db_column: loss_event_place 
     */ 	
	public java.lang.String lossEventPlace;
    /**
     * caseDescription       db_column: case_description 
     */ 	
	public java.lang.String caseDescription;
    /**
     * reporterName       db_column: reporter_name 
     */ 	
	public java.lang.String reporterName;
    /**
     * reporterContact       db_column: reporter_contact 
     */ 	
	public java.lang.String reporterContact;
    /**
     * haveThirdParty       db_column: have_third_party 
     */ 	
	public java.lang.Boolean haveThirdParty;
    /**
     * thirdPartyInjury       db_column: third_party_injury 
     */ 	
	public java.lang.String thirdPartyInjury;
    /**
     * thirdPartyProperty       db_column: third_party_property 
     */ 	
	public java.lang.String thirdPartyProperty;
    /**
     * thirdPartyPropertyOwner       db_column: third_party_property_owner 
     */ 	
	public java.lang.String thirdPartyPropertyOwner;
    /**
     * remark       db_column: remark 
     */ 	
	public java.lang.String remark;
    /**
     * createTime       db_column: create_time 
     */ 	
	public java.util.Date createTime;
	//columns END


	 
	public DtsNongReportCase(){
		setCreateTime(new Date());
		setReportCaseId(String.valueOf( System.currentTimeMillis()));
		setHaveThirdParty(false);
	}
	 
	 
	

	public void setReportCaseId(java.lang.String value) {
		this.reportCaseId = value;
	}
	

	public java.lang.String getReportCaseId() {
		return this.reportCaseId;
	}
	
	public java.lang.String getOrderNo() {
		return this.orderNo;
	}
	
	public void setOrderNo(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
         }
		this.orderNo = value;
	}
	
	public java.lang.String getPolicyNo() {
		return this.policyNo;
	}
	
	public void setPolicyNo(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
         }
		this.policyNo = value;
	}
	
	
	public java.util.Date getLossEventTime() {
		return this.lossEventTime;
	}
	
	public void setLossEventTime(java.util.Date value) {
		this.lossEventTime = value;
	}
	
	public java.lang.String getLossEventPlace() {
		return this.lossEventPlace;
	}
	
	public void setLossEventPlace(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
         }
		this.lossEventPlace = value;
	}
	
	public java.lang.String getCaseDescription() {
		return this.caseDescription;
	}
	
	public void setCaseDescription(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
         }
		this.caseDescription = value;
	}
	
	public java.lang.String getReporterName() {
		return this.reporterName;
	}
	
	public void setReporterName(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
         }
		this.reporterName = value;
	}
	
	public java.lang.String getReporterContact() {
		return this.reporterContact;
	}
	
	public void setReporterContact(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
         }
		this.reporterContact = value;
	}
	
	public java.lang.Boolean getHaveThirdParty() {
		return this.haveThirdParty;
	}
	
	public void setHaveThirdParty(java.lang.Boolean value) {
		this.haveThirdParty = value;
	}
	
	public java.lang.String getThirdPartyInjury() {
		return this.thirdPartyInjury;
	}
	
	public void setThirdPartyInjury(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
         }
		this.thirdPartyInjury = value;
	}
	
	public java.lang.String getThirdPartyProperty() {
		return this.thirdPartyProperty;
	}
	
	public void setThirdPartyProperty(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
         }
		this.thirdPartyProperty = value;
	}
	
	public java.lang.String getThirdPartyPropertyOwner() {
		return this.thirdPartyPropertyOwner;
	}
	
	public void setThirdPartyPropertyOwner(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
         }
		this.thirdPartyPropertyOwner = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	
	public void setRemark(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
         }
		this.remark = value;
	}
	
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	

}
