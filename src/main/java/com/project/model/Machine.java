package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="machine_details")
public class Machine {
	
	@Id
	@GeneratedValue
	@Column(name = "mid")
	private int mid;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "machine_model")
	private String machineModel;
	
	@Column(unique = true, name = "serial_no")
	private String serialNo;
	
	@Column(name = "issued_on_date")
	private String issuedOnDate;
	
	@Column(name = "issued_on_name")
	private String issuedOnName;
	
	@Column(name = "gpu_card")
	private String gpuCard;
	
	@Column(name = "gpu_card_serial_number")
	private String gpuCardSerialNumber;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "status")
	private String status;
	
	public Machine() {
		this.status = "Available";
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getMachineModel() {
		return machineModel;
	}
	public void setMachineModel(String machineModel) {
		this.machineModel = machineModel;
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
		return "Machine [mid=" + mid + ", manufacturer=" + manufacturer + ", machineModel=" + machineModel + ", serialNo="
				+ serialNo + ", issuedOnDate=" + issuedOnDate + ", issuedOnName=" + issuedOnName + ", gpuCard="
				+ gpuCard + ", gpuCardSerialNumber=" + gpuCardSerialNumber + ", mobile=" + mobile + ", comment="
				+ comment + ", status=" + status + "]";
	}
	
}
