package com.zhengzhaoxi.webdemo.model;

import java.util.List;

public class NongSurveyInfo {
    private String orderNo;
    private String reportCaseNo;
    private String surveyDescription;
    private java.math.BigDecimal fixedLossAmount;
    private java.lang.Boolean containsThirdParty;
    private List<DtsNongThirdInjuredPersonPojo> thirdInjuredPersonList;
    private List<DtsNongThirdPartyLossPojo> thirdPartyLossList;

    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getReportCaseNo() {
        return reportCaseNo;
    }
    public void setReportCaseNo(String reportCaseNo) {
        this.reportCaseNo = reportCaseNo;
    }
    public String getSurveyDescription() {
        return surveyDescription;
    }
    public void setSurveyDescription(String surveyDescription) {
        this.surveyDescription = surveyDescription;
    }
    public java.math.BigDecimal getFixedLossAmount() {
        return fixedLossAmount;
    }
    public void setFixedLossAmount(java.math.BigDecimal fixedLossAmount) {
        this.fixedLossAmount = fixedLossAmount;
    }
    public java.lang.Boolean getContainsThirdParty() {
        return containsThirdParty;
    }
    public void setContainsThirdParty(java.lang.Boolean containsThirdParty) {
        this.containsThirdParty = containsThirdParty;
    }
    public List<DtsNongThirdInjuredPersonPojo> getThirdInjuredPersonList() {
        return thirdInjuredPersonList;
    }
    public void setThirdInjuredPersonList(List<DtsNongThirdInjuredPersonPojo> thirdInjuredPersonList) {
        this.thirdInjuredPersonList = thirdInjuredPersonList;
    }
    public List<DtsNongThirdPartyLossPojo> getThirdPartyLossList() {
        return thirdPartyLossList;
    }
    public void setThirdPartyLossList(List<DtsNongThirdPartyLossPojo> thirdPartyLossList) {
        this.thirdPartyLossList = thirdPartyLossList;
    }
}
