package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Product;

public class FetchProductMain {

	public static void main(String[] args) {
		
		int productId = 30;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");		
		EntityManager entityManager = factory.createEntityManager();
		
		Product product = entityManager.find(Product.class, productId);
		
		if(product!=null) {
			System.out.println("ProductId: "+product.getProductId());
			System.out.println("Name :"+product.getProductName());
			System.out.println("Price : "+product.getProductPrice());
			System.out.println("Category: "+product.getCategory());
			System.out.println("CreatedOn: "+product.getCreatedDate());
		}
		else {
			System.out.println("Product Not exsting with id");
		}	
		
		entityManager.close();
		factory.close();		
		
	}
}
