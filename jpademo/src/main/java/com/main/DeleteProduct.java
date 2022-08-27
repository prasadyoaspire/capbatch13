package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Product;

public class DeleteProduct {

	public static void main(String[] args) {
		
		int productId = 400;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");		
		EntityManager entityManager = factory.createEntityManager();
		
		Product product = entityManager.find(Product.class, productId);
		
		entityManager.getTransaction().begin();
		
		if(product!=null) {		
			
			entityManager.remove(product);
			System.out.println("Product is deleted");
		}
		else {
			System.out.println("Product is not existing with id: "+productId);
		}	
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();			

	}

}
