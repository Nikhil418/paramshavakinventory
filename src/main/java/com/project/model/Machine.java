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
	private int mid;
	private String manufacture;
	private String machinemodel;
	@Column(unique = true)
	private String serialno;
	private String issued_on_date;
	private String issued_on_name;
	private String gpu_card;
	private String gpu_card_serial_number;
	private String mobile;
	private String comment;
	@ColumnDefault(value = "Available")
	private String status;
	
	
	
	public Machine() {
		super();
		this.manufacture = null;
		this.machinemodel = null;
		this.serialno = null;
		this.issued_on_date = null;
		this.issued_on_name = null;
		this.gpu_card = null;
		this.gpu_card_serial_number = null;
		this.mobile = null;
		this.comment = null;
		this.status=null;
	}



	public Machine(String manufacture, String machinemodel, String serialno, String issued_on_date,
			String issued_on_name, String gPU_card, String gPU_card_Serial_Number, String mobile,
			String comment,String status) {
		super();
		this.manufacture = manufacture;
		this.machinemodel = machinemodel;
		this.serialno = serialno;
		this.issued_on_date = issued_on_date;
		this.issued_on_name = issued_on_name;
		this.gpu_card = gPU_card;
		this.gpu_card_serial_number = gPU_card_Serial_Number;
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



	public int getMid() {
		return mid;
	}



	public void setMid(int mid) {
		this.mid = mid;
	}


	public String getManufacture() {
		return manufacture;
	}


	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}



	public String getMachinemodel() {
		return machinemodel;
	}



	public void setMachinemodel(String machinemodel) {
		this.machinemodel = machinemodel;
	}



	public String getSerialno() {
		return serialno;
	}



	public void setSerialno(String serialno) {
		this.serialno = serialno;
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


	public String getGpu_card() {
		return gpu_card;
	}



	public void setGpu_card(String gpu_card) {
		this.gpu_card = gpu_card;
	}



	public String getGpu_card_serial_number() {
		return gpu_card_serial_number;
	}



	public void setGpu_card_serial_number(String gpu_card_serial_number) {
		this.gpu_card_serial_number = gpu_card_serial_number;
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
		return "Machine [manufacture=" + manufacture + ", machinemodel=" + machinemodel + ", serialno=" + serialno
				+ ", issued_on_date=" + issued_on_date + ", issued_on_name=" + issued_on_name + ", gpu_card=" + gpu_card
				+ ", gpu_card_serial_number=" + gpu_card_serial_number + ", mobile=" + mobile + ", comment=" + comment
				+ ", status=" + status + "]";
	}



	
	
	
}
