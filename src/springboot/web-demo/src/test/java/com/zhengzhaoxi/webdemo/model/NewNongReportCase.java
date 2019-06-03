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
	
}
