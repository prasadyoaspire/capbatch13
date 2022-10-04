package com.abc.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.ecom.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public  List<Product> findByCategory(String category);
}
