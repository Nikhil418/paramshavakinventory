package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User {

	@Id
	@GeneratedValue
	private int uid;
	private String username;
	private String password;
	private String role;
	
	
	public User() {
		super();
		this.username = null;
		this.password = null;
		this.role = null;
	}


	public User(String username, String password, String role) {
		super();
		
		this.username = username;
		this.password = password;
		this.role = role;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUname() {
		return username;
	}


	public void setUname(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + "]";
	} 
	
	
}
