package com.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_tbl")
public class Customer {

	@Id
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="firstname", length = 30, nullable = false )
	private String firstName;
	
	@Column(name="lastname", length=30, nullable = false)
	private String lastName;
	
	@Column(name="dob")
	private LocalDate dateOfBirth;
	
	@Column(name="email",unique = true, nullable=false)
	private String email;
	
	@Column(name="mobile", length = 10)
	private String mobile;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}	
}
