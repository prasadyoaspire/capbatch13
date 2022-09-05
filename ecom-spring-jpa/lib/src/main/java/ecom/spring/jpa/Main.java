package ecom.spring.jpa;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ecom.spring.jpa.controller.ProductController;
import ecom.spring.jpa.entity.Product;

public class Main {

	public static void main(String[] args) {
		
		Product product = new Product();
		product.setProductId(999);
		product.setProductName("newbrand4");
		product.setProductPrice(89988);
		product.setCategory("newcategory4");
		product.setCreatedOn(LocalDate.of(2022, 05, 9));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
		
		ProductController productController = context.getBean(ProductController.class);
		
		productController.addProduct(product);

	}

}
