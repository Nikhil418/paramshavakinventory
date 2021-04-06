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
	private int gpuid;
	private String gpuCard;
	@Column(unique = true)
	private String gpuCardSerialNumber;
	private String issued_on_date;
	private String issued_on_name;
	private String mobile;
	private String comment;
	private String status;
	
	
	public GPUCard() {
		super();
		this.gpuCard = null;
		this.gpuCardSerialNumber = null;
		this.issued_on_date = null;
		this.issued_on_name = null;
		this.mobile = null;
		this.comment = null;
		this.status=null;
	}


	public GPUCard(String gpuCard, String gpuCardSerialNumber, String issued_on_date, String issued_on_name,
			String mobile, String comment,String status) {
		super();
		this.gpuCard = gpuCard;
		this.gpuCardSerialNumber = gpuCardSerialNumber;
		this.issued_on_date = issued_on_date;
		this.issued_on_name = issued_on_name;
		this.mobile = mobile;
		this.comment = comment;
		this.status=status;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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


	public String getIssued_on_date() {
		return issued_on_date;
	}


	public void setIssued_on_date(String issued_on_date) {
		this.issued_on_date = issued_on_date;
	}


	public String getIssued_on_name() {
		return issued_on_name;
	}


	public void setIssued_on_name(String issued_on_name) {
		this.issued_on_name = issued_on_name;
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


	@Override
	public String toString() {
		return "GPUCard [gpuCard=" + gpuCard + ", gpuCardSerialNumber=" + gpuCardSerialNumber + ", issued_on_date="
				+ issued_on_date + ", issued_on_name=" + issued_on_name + ", mobile=" + mobile + ", comment=" + comment
				+ ", status=" + status + "]";
	}


	
	
	
	
}
