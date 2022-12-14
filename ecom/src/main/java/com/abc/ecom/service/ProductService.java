package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.entity.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(int productId);
	
	public void deleteProduct(int productId);
	
	public Product updateProduct(Product product);
}
