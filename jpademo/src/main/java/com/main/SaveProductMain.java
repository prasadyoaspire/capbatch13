package com.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Product;

public class SaveProductMain {

	public static void main(String[] args) {
		
		Product product = new Product();
		product.setProductId(40);
		product.setProductName("IPhoneY");
		product.setProductPrice(90000);
		product.setCategory("mobile");
		product.setCreatedDate(LocalDate.of(2022, 8, 25));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(product);
		System.out.println("Product saved");
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();		
		
	}

}
