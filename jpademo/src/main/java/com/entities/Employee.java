package com.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_tbl")
public class Employee {
	
	@Id
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="firstname",length = 30, nullable = false)
	private String firstName;
	
	@Column(name="lastname",length = 30, nullable = false)
	private String lastName;
	
	@Column(name="email",length = 40, nullable = false, unique = true)
	private String email;
	
	@Column(name="mobile",length = 10)
	private String mobile;
	
	@Column(name="dob")
	private LocalDate dateOfBirth;
	
	@ManyToOne
	@JoinColumn(name="dept_no")
	private Department dept;
	

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
}
