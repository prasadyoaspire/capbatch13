package com.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entities.Product;

public class FetchAllProducts {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");		
		EntityManager entityManager = factory.createEntityManager();
		
		//fetch all products
		System.out.println("*********All Products**********");
		
		Query q1 = entityManager.createQuery("select p from Product p");
		List<Product> productList = q1.getResultList();		
		productList.forEach(p-> System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getProductPrice()+" "+p.getCategory()+" "+p.getCreatedDate()));
		
		System.out.println("*********All Products Under Mobile Category*********");
		
		Query q2 = entityManager.createQuery("select p from Product p where p.category = 'mobile'");
		List<Product> mobileProducts = q2.getResultList();		
		mobileProducts.forEach(p-> System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getProductPrice()+" "+p.getCategory()+" "+p.getCreatedDate()));
		
		System.out.println("*********All Products (Using TypedQuery)*********");
		
		TypedQuery<Product> q3 = entityManager.createQuery("select p from Product p", Product.class);
		List<Product> allProducts = q3.getResultList();
		allProducts.forEach(p-> System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getProductPrice()+" "+p.getCategory()+" "+p.getCreatedDate()));
		
		entityManager.close();
		factory.close();	
	}

}
