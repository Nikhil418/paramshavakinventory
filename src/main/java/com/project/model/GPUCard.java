package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gpucard_details")
public class GPUCard {
	@Id
	@GeneratedValue
	@Column(name = "gpuid")
	private int gpuid;
	
	@Column(name = "gpu_card")
	private String gpuCard;
	
	@Column(unique = true, name="gpu_card_serial_number")
	private String gpuCardSerialNumber;
	
	@Column(name = "issued_on_date")
	private String issuedOnDate;
	
	@Column(name = "issued_on_name")
	private String issuedOnName;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "status")
	private String status;
	
	
	public GPUCard() {
		super();
		this.status="Available";
	}


	public int getGpuid() {
		return gpuid;
	}


	public void setGpuid(int gpuid) {
		this.gpuid = gpuid;
	}


	public String getGpuCard() {
		return gpuCard;
	}


	public void setGpuCard(String gpuCard) {
		this.gpuCard = gpuCard;
	}


	public String getGpuCardSerialNumber() {
		return gpuCardSerialNumber;
	}


	public void setGpuCardSerialNumber(String gpuCardSerialNumber) {
		this.gpuCardSerialNumber = gpuCardSerialNumber;
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


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "GPUCard [gpuid=" + gpuid + ", gpuCard=" + gpuCard + ", gpuCardSerialNumber=" + gpuCardSerialNumber
				+ ", issuedOnDate=" + issuedOnDate + ", issuedOnName=" + issuedOnName + ", mobile=" + mobile
				+ ", comment=" + comment + ", status=" + status + "]";
	}
}
