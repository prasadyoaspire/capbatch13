package com.ecom.controller;

import com.ecom.service.ProductService;

public class ProductController {

	public void placeOrder(int productId,int quantity) {
		
		ProductService productService = new ProductService();
		double totalOrderAmount =productService.calculateOrderAmount(productId, quantity);
		System.out.println("Total Order Amount: "+totalOrderAmount);
	}
	
	public static void main(String[] args) {
		
		int productId = 20;
		int quantity = 2;
		
		ProductController productController = new ProductController();
		productController.placeOrder(productId, quantity);
	}
}
