package com.project.model;

public class DeliveryCount {

	private String paramshavakversion;
	private long count;
	
	public DeliveryCount() {
		// TODO Auto-generated constructor stub
	}

	public DeliveryCount(String paramshavakversion, long count) {
		super();
		this.paramshavakversion = paramshavakversion;
		this.count = count;
	}

	public String getParamshavakversion() {
		return paramshavakversion;
	}

	public void setParamshavakversion(String paramshavakversion) {
		this.paramshavakversion = paramshavakversion;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	
}
