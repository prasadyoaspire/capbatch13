package com.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Department;
import com.entities.Employee;

public class OneToManyFetch {

	public static void main(String[] args) {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");			
		EntityManager entityManager = factory.createEntityManager();
		
		int deptId = 10;
		
		Department dept = entityManager.find(Department.class, deptId);
		
		int departmentId = dept.getDeptId();
		String departmentName = dept.getDeptName();
		
		System.out.println("DeptId: "+departmentId);
		System.out.println("Dept Name: "+departmentName);
		
		List<Employee> deptEmployees = dept.getEmployees();
		System.out.println("Employees in the department: ");		
		deptEmployees.forEach(e-> System.out.println(e.getEmpId()+" "+e.getFirstName()+" "+e.getLastName()+" "+e.getEmail()));
		
		entityManager.close();
		factory.close();
	}

}
