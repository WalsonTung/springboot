package com.zhengzhaoxi.webdemo.model;

import java.util.Date;

public class DtsNongReportCase  implements java.io.Serializable{
	//date formats
		public static final String FORMAT_LOSS_EVENT_TIME = "yyyy-MM-dd";
		public static final String FORMAT_REPORT_TIME = "yyyy-MM-dd";
		public static final String FORMAT_CREATE_TIME = "yyyy-MM-dd";
		

		//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
		//columns START
	    /**
	     * śä•ś°ąID       db_column: report_case_id 
	     */ 	
		public java.lang.String reportCaseId;
	    /**
	     * śä•ś°ąŤģĘŚćēŚŹ∑       db_column: order_no 
	     */ 	
		public java.lang.String orderNo;
	    /**
	     * šŅĚŚćēŚŹ∑       db_column: policy_no 
	     */ 	
		public java.lang.String policyNo;
	    /**
	     * Śáļťô©śó∂ťóī       db_column: loss_event_time 
	     */ 	
		public java.util.Date lossEventTime;
	    /**
	     * Śáļťô©ŚúįÁāĻ       db_column: loss_event_place 
	     */ 	
		public java.lang.String lossEventPlace;
	    /**
	     * Śáļťô©šļčśēÖÁĽŹŤŅá       db_column: case_description 
	     */ 	
		public java.lang.String caseDescription;
	    /**
	     * śä•ś°ąšļļ       db_column: reporter_name 
	     */ 	
		public java.lang.String reporterName;
	    /**
	     * śä•ś°ąšļļÁĒĶŤĮĚ       db_column: reporter_phone_number 
	     */ 	
		public java.lang.String reporterPhoneNumber;
	    /**
	     * śä•ś°ąšļļŤĀĒÁ≥ĽŚúįŚĚÄ       db_column: reporter_address 
	     */ 	
		public java.lang.String reporterAddress;
	    /**
	     * śÄĽšľįśćüťáĎťĘĚ       db_column: total_estimated_loss_amount 
	     */ 	
		public java.math.BigDecimal totalEstimatedLossAmount;
	    /**
	     * śä•ś°ąŚŹ∑       db_column: report_case_no 
	     */ 	
		public java.lang.String reportCaseNo;
	    /**
	     * śä•ś°ąśó∂ťóī       db_column: report_time 
	     */ 	
		public java.util.Date reportTime;
	    /**
	     * śü•ŚčėśÉÖŚÜĶ       db_column: survey_description 
	     */ 	
		public java.lang.String surveyDescription;
	    /**
	     * ŚģöśćüťáĎťĘĚ       db_column: fixed_loss_amount 
	     */ 	
		public java.math.BigDecimal fixedLossAmount;
	    /**
	     * śėĮŚź¶śúČšłČŤÄÖ       db_column: contains_third_party 
	     */ 	
		public java.lang.Boolean containsThirdParty;
	    /**
	     * ś°ąšĽ∂Áä∂śÄĀ       db_column: case_status 
	     */ 	
		public java.lang.String caseStatus;
	    /**
	     * śēįśćģŚąõŚĽļśó∂ťóī       db_column: create_time 
	     */ 	
		public java.util.Date createTime;
		//columns END


		 
		public DtsNongReportCase(){
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
		
		public java.lang.String getReporterPhoneNumber() {
			return this.reporterPhoneNumber;
		}
		
		public void setReporterPhoneNumber(java.lang.String value) {
	        if(value!=null){
	            if("".equals(value.trim()))
	            {
	                // 将前端的空字符串转化成null
	                value= null;
	            }
	         }
			this.reporterPhoneNumber = value;
		}
		
		public java.lang.String getReporterAddress() {
			return this.reporterAddress;
		}
		
		public void setReporterAddress(java.lang.String value) {
	        if(value!=null){
	            if("".equals(value.trim()))
	            {
	                // 将前端的空字符串转化成null
	                value= null;
	            }
	         }
			this.reporterAddress = value;
		}
		
		public java.math.BigDecimal getTotalEstimatedLossAmount() {
			return this.totalEstimatedLossAmount;
		}
		
		public void setTotalEstimatedLossAmount(java.math.BigDecimal value) {
			this.totalEstimatedLossAmount = value;
		}
		
		public java.lang.String getReportCaseNo() {
			return this.reportCaseNo;
		}
		
		public void setReportCaseNo(java.lang.String value) {
	        if(value!=null){
	            if("".equals(value.trim()))
	            {
	                // 将前端的空字符串转化成null
	                value= null;
	            }
	         }
			this.reportCaseNo = value;
		}
		
		
		public java.util.Date getReportTime() {
			return this.reportTime;
		}
		
		public void setReportTime(java.util.Date value) {
			this.reportTime = value;
		}
		
		public java.lang.String getSurveyDescription() {
			return this.surveyDescription;
		}
		
		public void setSurveyDescription(java.lang.String value) {
	        if(value!=null){
	            if("".equals(value.trim()))
	            {
	                // 将前端的空字符串转化成null
	                value= null;
	            }
	         }
			this.surveyDescription = value;
		}
		
		public java.math.BigDecimal getFixedLossAmount() {
			return this.fixedLossAmount;
		}
		
		public void setFixedLossAmount(java.math.BigDecimal value) {
			this.fixedLossAmount = value;
		}
		
		public java.lang.Boolean getContainsThirdParty() {
			return this.containsThirdParty;
		}
		
		public void setContainsThirdParty(java.lang.Boolean value) {
			this.containsThirdParty = value;
		}
		
		public java.lang.String getCaseStatus() {
			return this.caseStatus;
		}
		
		public void setCaseStatus(java.lang.String value) {
	        if(value!=null){
	            if("".equals(value.trim()))
	            {
	                // 将前端的空字符串转化成null
	                value= null;
	            }
	         }
			this.caseStatus = value;
		}
		
		
		public java.util.Date getCreateTime() {
			return this.createTime;
		}
		
		public void setCreateTime(java.util.Date value) {
			this.createTime = value;
		}
		

		

	

}
