package com.main;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Course;
import com.entities.Student;

public class ManyToManySave {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");			
		EntityManager entityManager = factory.createEntityManager();
		
		Course course1 = new Course();
		course1.setCourseId(777);
		course1.setCourseName("core java");
		course1.setDuration(30);
		course1.setFees(5000);
		
		Course course2 = new Course();
		course2.setCourseId(888);
		course2.setCourseName("sql");
		course2.setDuration(25);
		course2.setFees(3000);
		
		Course course3 = new Course();
		course3.setCourseId(999);
		course3.setCourseName("react");
		course3.setDuration(40);
		course3.setFees(9000);
		
		//student1 courses
		Set<Course> coursesOne = new HashSet<>();
		coursesOne.add(course1); //corejava
		coursesOne.add(course2); //sql
				
		//studnet2 courses
		Set<Course> coursesTwo = new HashSet<>();
		coursesTwo.add(course2); //sql
		coursesTwo.add(course3); //react		
		
		Student student1 = new Student();
		student1.setStudentId(5001);
		student1.setStudentName("raj");
		student1.setAge(26);
		student1.setEmail("raj@tmail.com");
		
		student1.setCourses(coursesOne); // corejava, sql
		
		Student student2 = new Student();
		student2.setStudentId(5002);
		student2.setStudentName("sam");
		student2.setAge(24);
		student2.setEmail("sam@tmail.com");
		
		student2.setCourses(coursesTwo); // sql,react
		
		Set<Student> coreJavaStudents = new HashSet<>();
		coreJavaStudents.add(student1);
		
		Set<Student> sqlStudents = new HashSet<>();
		sqlStudents.add(student1);
		sqlStudents.add(student2);
		
		Set<Student> reactStudents = new HashSet<>();
		reactStudents.add(student2);
		
		course1.setStudents(coreJavaStudents);
		course2.setStudents(sqlStudents);
		course3.setStudents(reactStudents);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		
		entityManager.persist(student1);
		entityManager.persist(student2);
		
		entityManager.getTransaction().commit();
		System.out.println("studnet course saved.");
		entityManager.close();
		factory.close();
	}

}
