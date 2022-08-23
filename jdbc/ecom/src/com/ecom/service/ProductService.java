package com.ecom.service;

import com.ecom.bean.Product;
import com.ecom.dao.ProductDao;

public class ProductService {

	public double calculateOrderAmount(int productId, int quantity) {
		
		//get product details from database using productId
		ProductDao productDao = new ProductDao();
		Product product = productDao.getProductById(productId);
			
		//calculate the total :  productPrice * quantity
		double total = product.getProductPrice() * quantity;
		
		//calculate GST 12% and add to the total
		double totalOrderAmount = total + (total*0.12);
				
		return totalOrderAmount;
		
	}
	
	public void saveProduct(Product product) {
		
		ProductDao productDao = new ProductDao();
		productDao.save(product);
	}
}
