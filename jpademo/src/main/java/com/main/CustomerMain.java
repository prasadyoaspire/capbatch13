package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		
		int customerId = 1001;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");	
		
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();		
		Customer customer = entityManager.find(Customer.class, customerId); // customer object is inside managed state
		
		customer.setFirstName("Pavan");
		
		entityManager.getTransaction().commit();	
		
		entityManager.close(); // customer object is inside detached stated
		
		EntityManager entityManager2 = factory.createEntityManager();
		
		customer.setFirstName("dfdfdfdfd");
		
		entityManager2.getTransaction().begin();	
		entityManager2.merge(customer);
		entityManager2.getTransaction().commit();	
		entityManager2.close();		
		
		factory.close();	
	}

}
