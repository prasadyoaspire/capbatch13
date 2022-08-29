package com.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course_tbl")
public class Course {

	@Id
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="course_name", length = 20, nullable = false,unique = true)
	private String courseName;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="fees")
	private double fees;
	
	@ManyToMany
	@JoinTable(
			  name = "course_student_tbl", 
			  joinColumns = @JoinColumn(name = "course_id"), 
			  inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<Student> students;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
