package com.zhengzhaoxi.webdemo.model;

public class JsonResult {
    public String getMsgCode() {
		return msgCode;
	}
	public String getMsgName() {
		return msgName;
	}
	public boolean isResult() {
		return result;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	private String msgCode;
    private String msgName;
    private boolean result;
}
