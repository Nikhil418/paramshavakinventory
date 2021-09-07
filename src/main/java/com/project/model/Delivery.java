package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="delivery_details")
public class Delivery {
	
	@Id
	@GeneratedValue
	@Column(name = "did")
	private int did;
	
	@Column(name = "param_shavak_variant")
	private String paramShavakVariant;
	
	@Column(name = "machine_manufacturer")
	private String machineManufacturer;
	
	@Column(name = "machine_model")
	private String machineModel;
	
	@Column(unique = true, name = "monitor_serial_no")
	private String monitorSerialNo;
	
	@Column(name = "monitor_manufacturer")
	private String monitorManufacturer;
	
	@Column(name = "monitor_model")
	private String monitorModel;
	
	@Column(unique = true, name = "machine_serial_no")
	private String machineSerialNo;
	
	@Column(name = "disptach_date")
	private String disptachDate;
	
	@Column(name = "system_installed_by")
	private String systemInstalledBy;
	
	@Column(name = "param_shavak_version")
	private String paramShavakVersion;
	
	@Column(name = "in_built_gpu_card")
	private String inBuiltGpuCard;
	
	@Column(name = "studio_license")
	private String studioLicense;
	
	@Column(name = "gpu_card")
	private String gpuCard;
	
	@Column(name = "gpu_card_serial_no")
	private String gpuCardSerialNo;
	
	@Column(name = "institute_name")
	private String instituteName;
	
	@Column(name = "institut_address")
	private String institutAddress;
	
	@Column(name = "contact_person_name")
	private String contactPersonName;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "comment")
	private String comment;  
	
	@Column(name = "status")
	private String status;
	
	public Delivery() {
		this.did = 0;
		this.status = "Dispatched";
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getParamShavakVariant() {
		return paramShavakVariant;
	}

	public void setParamShavakVariant(String paramShavakVariant) {
		this.paramShavakVariant = paramShavakVariant;
	}

	public String getMonitorSerialNo() {
		return monitorSerialNo;
	}

	public void setMonitorSerialNo(String monitorSerialNo) {
		this.monitorSerialNo = monitorSerialNo;
	}

	public String getMachineManufacturer() {
		return machineManufacturer;
	}

	public void setMachineManufacturer(String machineManufacturer) {
		this.machineManufacturer = machineManufacturer;
	}

	public String getMonitorManufacturer() {
		return monitorManufacturer;
	}

	public void setMonitorManufacturer(String monitorManufacturer) {
		this.monitorManufacturer = monitorManufacturer;
	}

	public String getMonitorModel() {
		return monitorModel;
	}

	public void setMonitorModel(String monitorModel) {
		this.monitorModel = monitorModel;
	}

	public String getMachineModel() {
		return machineModel;
	}

	public void setMachineModel(String machineModel) {
		this.machineModel = machineModel;
	}

	public String getMachineSerialNo() {
		return machineSerialNo;
	}

	public void setMachineSerialNo(String machineSerialNo) {
		this.machineSerialNo = machineSerialNo;
	}

	public String getDisptachDate() {
		return disptachDate;
	}

	public void setDisptachDate(String disptachDate) {
		this.disptachDate = disptachDate;
	}

	public String getSystemInstalledBy() {
		return systemInstalledBy;
	}

	public void setSystemInstalledBy(String systemInstalledBy) {
		this.systemInstalledBy = systemInstalledBy;
	}

	public String getParamShavakVersion() {
		return paramShavakVersion;
	}

	public void setParamShavakVersion(String paramShavakVersion) {
		this.paramShavakVersion = paramShavakVersion;
	}

	public String getInBuiltGpuCard() {
		return inBuiltGpuCard;
	}

	public void setInBuiltGpuCard(String inBuiltGpuCard) {
		this.inBuiltGpuCard = inBuiltGpuCard;
	}

	public String getStudioLicense() {
		return studioLicense;
	}

	public void setStudioLicense(String studioLicense) {
		this.studioLicense = studioLicense;
	}

	public String getGpuCard() {
		return gpuCard;
	}

	public void setGpuCard(String gpuCard) {
		this.gpuCard = gpuCard;
	}

	public String getGpuCardSerialNo() {
		return gpuCardSerialNo;
	}

	public void setGpuCardSerialNo(String gpuCardSerialNo) {
		this.gpuCardSerialNo = gpuCardSerialNo;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getInstitutAddress() {
		return institutAddress;
	}

	public void setInstitutAddress(String institutAddress) {
		this.institutAddress = institutAddress;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
		return "Delivery [did=" + did + ", paramShavakVariant=" + paramShavakVariant + ", machineManufacturer="
				+ machineManufacturer + ", machineModel=" + machineModel + ", monitorSerialNo=" + monitorSerialNo
				+ ", monitorManufacturer=" + monitorManufacturer + ", monitorModel=" + monitorModel + ", machineSerialNo="
				+ machineSerialNo + ", disptachDate=" + disptachDate + ", systemInstalledBy=" + systemInstalledBy
				+ ", paramShavakVersion=" + paramShavakVersion + ", inBuiltGpuCard=" + inBuiltGpuCard
				+ ", studioLicense=" + studioLicense + ", gpuCard=" + gpuCard + ", gpuCardSerialNo=" + gpuCardSerialNo
				+ ", instituteName=" + instituteName + ", institutAddress=" + institutAddress + ", contactPersonName="
				+ contactPersonName + ", mobile=" + mobile + ", emailId=" + emailId + ", comment=" + comment
				+ ", status=" + status + "]";
	}
	
}
