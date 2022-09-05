package ecom.spring.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ecom.spring.jpa.entity.Product;

@Repository
public class ProductDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Product product) {	
		
		entityManager.persist(product);
	}
	
}
