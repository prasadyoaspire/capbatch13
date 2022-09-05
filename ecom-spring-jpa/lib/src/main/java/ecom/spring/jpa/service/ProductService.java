package ecom.spring.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecom.spring.jpa.dao.ProductDao;
import ecom.spring.jpa.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;	
	
	/*
	 * public void setProductDao(ProductDao productDao) { this.productDao =
	 * productDao; }
	 */

	@Transactional
	public void saveProduct(Product product) {
		
		productDao.save(product);
	}
}
