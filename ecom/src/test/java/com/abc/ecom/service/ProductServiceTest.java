package com.abc.ecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ProductNotFoundException;
import com.abc.ecom.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {
	
	@InjectMocks
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	
	@Mock
	ProductRepository productRepository;	
	
	@Test
	public void testGetProductById() {
		
		Product product = new Product();
		product.setProductId(1234);
		product.setProductName("IphoneX");
		product.setProductPrice(56000);
		product.setCreatedOn(LocalDate.of(2020, 10, 10));
		product.setCategory("mobile");
		
		Optional<Product> optionalProduct = Optional.of(product);
		
		when(productRepository.findById(1234)).thenReturn(optionalProduct);
		
		Product productObj = productServiceImpl.getProductById(1234);
		
		assertEquals("IphoneX",productObj.getProductName());
		assertEquals(56000,productObj.getProductPrice());		
	}
	
	@Test
	public void testGetProductByIdException() {
		
		when(productRepository.findById(1020)).thenThrow(ProductNotFoundException.class);
		
		assertThrows(ProductNotFoundException.class,()->productServiceImpl.getProductById(1020));
	}
	
	@Test
	public void testGetAllProducts() {
		
		Product product = new Product();
		product.setProductId(1111);
		product.setProductName("IphoneX");
		product.setProductPrice(56000);
		product.setCreatedOn(LocalDate.of(2020, 10, 10));
		product.setCategory("mobile");
		
		Product product2 = new Product();
		product2.setProductId(2222);
		product2.setProductName("IphoneY");
		product2.setProductPrice(46000);
		product2.setCreatedOn(LocalDate.of(2020, 10, 10));
		product2.setCategory("mobile");
		
		Product product3 = new Product();
		product3.setProductId(3333);
		product3.setProductName("IphoneZ");
		product3.setProductPrice(36000);
		product3.setCreatedOn(LocalDate.of(2020, 10, 10));
		product3.setCategory("mobile");
		
		List<Product> productList = new ArrayList<>();
		productList.add(product3);
		productList.add(product2);
		productList.add(product);
		
		when(productRepository.findAll()).thenReturn(productList);
		
		List<Product> products = productServiceImpl.getAllProducts();
		
		assertEquals(3, products.size());
	}
	
	@Test
	public void testDeleteProduct() {
		
		Product product = new Product();
		product.setProductId(1001);
		product.setProductName("IphoneX");
		product.setProductPrice(56000);
		product.setCreatedOn(LocalDate.of(2020, 10, 10));
		product.setCategory("mobile");
		
		Optional<Product> optionalProduct = Optional.of(product);
		
		when(productRepository.findById(1001)).thenReturn(optionalProduct);
		
		doNothing().when(productRepository).deleteById(1001);
		
		productServiceImpl.deleteProduct(1001);
		
		verify(productRepository,times(1)).findById(1001);
		verify(productRepository,times(1)).deleteById(1001);
	}
	
}
