package com.ecom.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.ecom.bean.Product;
import com.ecom.service.ProductService;

public class ProductController {

	public void placeOrder(int productId,int quantity) {
		
		ProductService productService = new ProductService();
		double totalOrderAmount =productService.calculateOrderAmount(productId, quantity);
		System.out.println("Total Order Amount: "+totalOrderAmount);
	}
	
	public void addProduct() {
		
//		int productId = 40;
//		String productName = "DellXP";
//		float productPrice = 150000;
//		String category = "computers";
//		LocalDate createdOn = LocalDate.of(2015, 01, 30);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ProuductId");
		int productId = sc.nextInt();
		System.out.println("Enter Prouduct Name");
		String productName = sc.next();
		System.out.println("Enter Prouduct Price");
		float productPrice = sc.nextFloat();
		System.out.println("Enter Prouduct Category");
		String category = sc.next();
		System.out.println("Enter Prouduct Created Date (yyyy-MM-dd)");
		String sdate = sc.next();		
		LocalDate createdOn = LocalDate.parse(sdate);
		sc.close();
		
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setCategory(category);
		product.setCreatedOn(createdOn);
		
		ProductService productService = new ProductService();
		productService.saveProduct(product);
		System.out.println("Product saved.");	
		
	}
	
	public void fetchAllProductByCategory() {
		
		String category = "mobile";
		
		ProductService service = new ProductService();
		
		List<Product> list = service.allProductsByCategory(category);
		
		list.forEach(p->System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getProductPrice()+" "+p.getCategory()));
	}
	
	public static void main(String[] args) {
		
		int productId = 20;
		int quantity = 2;
		
		ProductController productController = new ProductController();
		//productController.placeOrder(productId, quantity);
		//productController.addProduct();
		productController.fetchAllProductByCategory();
	}
}
