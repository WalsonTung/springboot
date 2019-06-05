package com.zhengzhaoxi.webdemo.model;

import java.util.Date;

public class DtsNongReportCase  implements java.io.Serializable{
	//date formats
		public static final String FORMAT_LOSS_EVENT_TIME = "yyyy-MM-dd";
		public static final String FORMAT_REPORT_TIME = "yyyy-MM-dd";
		public static final String FORMAT_CREATE_TIME = "yyyy-MM-dd";
		

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

		 
		public DtsNongReportCase(){
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


}
