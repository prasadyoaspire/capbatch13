package com.abc.ecom.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="admin_tbl")
public class Admin extends User  {
	
	private String adminName;
	private String email;
	private String phone;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
