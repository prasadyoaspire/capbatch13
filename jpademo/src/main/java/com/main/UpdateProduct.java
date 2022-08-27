package com.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Product;

public class UpdateProduct {

	public static void main(String[] args) {		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");		
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Product product = new Product();
		product.setProductId(200);
		product.setProductName("DellXPP");
		product.setProductPrice(120000);
		product.setCategory("computers");
		product.setCreatedDate(LocalDate.of(2015, 01, 30));
		
		Product existingProduct = entityManager.find(Product.class, product.getProductId());
		
		if(existingProduct != null) {
			entityManager.merge(product);
			System.out.println("Product Updated");
		}
		else {
			System.out.println("Product is not exising with id: "+product.getProductId());
		}		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();		
	}

}
