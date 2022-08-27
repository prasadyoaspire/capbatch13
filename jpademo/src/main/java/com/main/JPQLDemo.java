package com.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.entities.Customer;
import com.entities.Product;

public class JPQLDemo {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");		
		EntityManager entityManager = factory.createEntityManager();
		
		System.out.println("******All Customers*********");
		TypedQuery<Customer> q1 = entityManager.createQuery("Select c from Customer c",Customer.class);
		List<Customer> allCustomers = q1.getResultList();
		
		allCustomers.forEach(c->System.out.println(c.getCustomerId()+" "+c.getFirstName()+" "+c.getLastName()));
		
		System.out.println("******Search Customer by Email Address*********");
		//positional parameters
		String email = "raj@tmail.com";		
		TypedQuery<Customer> q2 = entityManager.createQuery("Select c from Customer c where c.email = ?1",Customer.class);
		q2.setParameter(1, email);
		
		Customer customer = q2.getSingleResult();
		
		System.out.println(customer.getCustomerId()+" "+customer.getFirstName()+" "+customer.getLastName());
		
		System.out.println("******All Products under Mobile*********");
		//named parameter
		String category = "mobile";
		TypedQuery<Product> q3 = entityManager.createQuery("select p from Product p where p.category = :cname",Product.class);
		q3.setParameter("cname",category);
		
		List<Product> productList = q3.getResultList();
		productList.forEach(p->System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getProductPrice()));		
		
		entityManager.close();
		factory.close();	

	}

}
