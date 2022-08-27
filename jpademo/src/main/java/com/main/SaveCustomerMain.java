package com.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Customer;

public class SaveCustomerMain {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setCustomerId(1002);
		customer.setFirstName("Rohit");
		customer.setLastName("Sharma");
		customer.setDateOfBirth(LocalDate.of(2001, 10, 30));
		customer.setEmail("rohit@tmail.com");
		customer.setMobile("9638527419");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");		
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();		
		entityManager.persist(customer);		
		entityManager.getTransaction().commit();
		
		System.out.println("customer is saved");
		
		entityManager.close();
		factory.close();	
	}

}
