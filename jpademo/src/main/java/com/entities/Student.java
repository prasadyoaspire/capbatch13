package com.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_tbl")
public class Student {

	@Id
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="student_name", length = 30)
	private String studentName;
	
	@Column(name="age")
	private int age;
	
	@Column(name="email",length = 30,unique = true, nullable = false)
	private String email;
	
	@ManyToMany(mappedBy = "students")
	private Set<Course> courses;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
