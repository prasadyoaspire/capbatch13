package ecom.spring.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ecom.spring.jpa.entity.Product;
import ecom.spring.jpa.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	/*
	 * public void setProductService(ProductService productService) {
	 * this.productService = productService; }
	 */
	
	public void addProduct(Product product) {
		
		productService.saveProduct(product);
		
		System.out.println("Product saved");
	}
}
