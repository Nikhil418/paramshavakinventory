package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monitor_details")
public class Monitor {
	
	@Id
	@GeneratedValue
	@Column(name = "moid")
	private int moid;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "monitor_model")
	private String monitorModel;
	
	@Column(name = "serial_no")
	private String serialNo;
	
	@Column(name = "issued_on_date")
	private String issuedOnDate;
	
	@Column(name = "issued_on_name")
	private String issuedOnName;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "comment")
	private String comment;
	
	public Monitor() {
		this.status = "Available";
	}

	public int getMoid() {
		return moid;
	}

	public void setMoid(int moid) {
		this.moid = moid;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getMonitorModel() {
		return monitorModel;
	}

	public void setMonitorModel(String monitorModel) {
		this.monitorModel = monitorModel;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getIssuedOnDate() {
		return issuedOnDate;
	}

	public void setIssuedOnDate(String issuedOnDate) {
		this.issuedOnDate = issuedOnDate;
	}

	public String getIssuedOnName() {
		return issuedOnName;
	}

	public void setIssuedOnName(String issuedOnName) {
		this.issuedOnName = issuedOnName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Monitor [moid=" + moid + ", manufacturer=" + manufacturer + ", monitorModel=" + monitorModel
				+ ", serialNo=" + serialNo + ", issuedOnDate=" + issuedOnDate + ", issuedOnName=" + issuedOnName
				+ ", mobile=" + mobile + ", status=" + status + ", comment=" + comment + "]";
	}
	
}
