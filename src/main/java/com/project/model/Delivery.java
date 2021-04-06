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
	private int did;
	private String paramshavakvarient;
	private String manufacture;
	private String machinemodel;
	@Column(unique = true)
	private String serialno;
	private String disptachdate;
	private String systeminstalledby;
	private String paramshavakversion;
	private String studiolicense;
	private String gpucard;
	private String gpucardsrno;
	private String institutename;
	private String institutaddress;
	private String contactpersonname;
	private String mobileno;
	private String emailid;
	private String Comment;  
	
	
	public Delivery() {
		super();
	}

	public String getParamshavakvarient() {
		return paramshavakvarient;
	}

	public void setParamshavakvarient(String paramshavakvarient) {
		this.paramshavakvarient = paramshavakvarient;
	}

	public String getManufacture() {
		return manufacture;
	}


	void setManufacture(String manufacture) {
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





	public String getGpucard() {
		return gpucard;
	}





	public void setGpucard(String gpucard) {
		this.gpucard = gpucard;
	}





	public String getGpucardsrno() {
		return gpucardsrno;
	}





	public void setGpucardsrno(String gpucardsrno) {
		this.gpucardsrno = gpucardsrno;
	}





	public Delivery(String paramshavakvarient, String manufacture, String machinemodel, String serialno, String disptachdate,
			String systeminstalledby, String paramshavakversion, String studiolicense, String gpucard,
			String gpucardsrno, String institutename, String institutaddress, String contactpersonname, String mobileno,
			String emailid, String comment) {
		super();
		this.paramshavakvarient = paramshavakvarient;
		this.manufacture = manufacture;
		this.machinemodel = machinemodel;
		this.serialno = serialno;
		this.disptachdate = disptachdate;
		this.systeminstalledby = systeminstalledby;
		this.paramshavakversion = paramshavakversion;
		this.studiolicense = studiolicense;
		this.gpucard = gpucard;
		this.gpucardsrno = gpucardsrno;
		this.institutename = institutename;
		this.institutaddress = institutaddress;
		this.contactpersonname = contactpersonname;
		this.mobileno = mobileno;
		this.emailid = emailid;
		Comment = comment;
	}





	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public String getDisptachdate() {
		return disptachdate;
	}


	public void setDisptachdate(String disptachdate) {
		this.disptachdate = disptachdate;
	}


	public String getSysteminstalledby() {
		return systeminstalledby;
	}


	public void setSysteminstalledby(String systeminstalledby) {
		this.systeminstalledby = systeminstalledby;
	}


	public String getStudiolicense() {
		return studiolicense;
	}


	public void setStudiolicense(String studiolicense) {
		this.studiolicense = studiolicense;
	}


	public String getParamshavakversion() {
		return paramshavakversion;
	}


	public void setParamshavakversion(String paramshavakversion) {
		this.paramshavakversion = paramshavakversion;
	}


	public String getInstitutename() {
		return institutename;
	}


	public void setInstitutename(String institutename) {
		this.institutename = institutename;
	}


	public String getInstitutaddress() {
		return institutaddress;
	}


	public void setInstitutaddress(String institutaddress) {
		this.institutaddress = institutaddress;
	}


	public String getContactpersonname() {
		return contactpersonname;
	}


	public void setContactpersonname(String contactpersonname) {
		this.contactpersonname = contactpersonname;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public String getComment() {
		return Comment;
	}


	public void setComment(String comment) {
		Comment = comment;
	}


	@Override
	public String toString() {
		return "Delivery [ paramshavakvarient=" + paramshavakvarient + ", manufacture=" + manufacture
				+ ", machinemodel=" + machinemodel + ", serialno=" + serialno + ", disptachdate=" + disptachdate
				+ ", systeminstalledby=" + systeminstalledby + ", paramshavakversion=" + paramshavakversion
				+ ", studiolicense=" + studiolicense + ", gpucard=" + gpucard + ", gpucardsrno=" + gpucardsrno
				+ ", institutename=" + institutename + ", institutaddress=" + institutaddress + ", contactpersonname="
				+ contactpersonname + ", mobileno=" + mobileno + ", emailid=" + emailid + ", Comment=" + Comment + "]";
	}
	
}
