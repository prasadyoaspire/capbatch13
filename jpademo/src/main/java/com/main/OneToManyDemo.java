package com.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Department;
import com.entities.Employee;

public class OneToManyDemo {

	public static void main(String[] args) {
		

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");			
		EntityManager entityManager = factory.createEntityManager();
		
		Employee emp1 = new Employee();
		emp1.setEmpId(1001);
		emp1.setFirstName("Raj");
		emp1.setLastName("Kumar");
		emp1.setEmail("raj@tmail.com");
		emp1.setMobile("9638527410");
		emp1.setDateOfBirth(LocalDate.of(2000, 10, 10));
		
		Employee emp2 = new Employee();
		emp2.setEmpId(1005);
		emp2.setFirstName("Rohit");
		emp2.setLastName("Sharma");
		emp2.setEmail("rohit@tmail.com");
		emp2.setMobile("9988776655");
		emp2.setDateOfBirth(LocalDate.of(2000, 10, 10));
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		
		Department dept1 = new Department();
		dept1.setDeptId(10);
		dept1.setDeptName("IT");
		dept1.setEmployees(employeeList);
		
		emp1.setDept(dept1);
		emp2.setDept(dept1);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(dept1);
		//entityManager.persist(emp1);
		//entityManager.persist(emp2);
		
		entityManager.getTransaction().commit();	
		System.out.println("Dept and employees saved.");
		
		
		entityManager.close();
		factory.close();
	}

}
