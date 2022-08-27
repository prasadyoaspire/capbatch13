package com.ecom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.ecom.bean.Product;
import com.ecom.util.JPAUtil;

public class ProductDao {
	
	EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();

	public Product getProductById(int productId) {	
	
		EntityManager entityManager = factory.createEntityManager();
		Product product =entityManager.find(Product.class, productId);
		entityManager.close();
		return product;		
	}
	
	public void save(Product product) {	
		
		EntityManager entityManager = factory.createEntityManager();		
		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();		
		entityManager.close();
	}
	
	public List<Product> getProductsByCategory(String category) {
		
		EntityManager entityManager = factory.createEntityManager();		
		//TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.category = :pcategory",Product.class);
		TypedQuery<Product> query = entityManager.createNamedQuery("getAllProductsByCategory", Product.class);
		query.setParameter("pcategory", category);		
		List<Product> products = query.getResultList();		
		entityManager.close();		
		return products;		
	}
	
	public void delete(int productId) {
		
	}
	
}
