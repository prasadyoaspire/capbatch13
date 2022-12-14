package com.abc.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ProductNotFoundException;
import com.abc.ecom.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) {
		Product newProduct = productRepository.save(product);
		return newProduct;
	}
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}
	
	@Override
	public Product getProductById(int productId)  {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product not existing with id: "+productId);
		}
		Product product = optionalProduct.get();
		return product;
	}

	@Override
	public void deleteProduct(int productId) {	
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product not existing with id: "+productId);
		}
		
		productRepository.deleteById(productId);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product not existing with id: "+product.getProductId());
		}
		Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}
}
