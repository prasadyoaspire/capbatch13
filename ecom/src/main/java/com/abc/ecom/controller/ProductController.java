package com.abc.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Product;
import com.abc.ecom.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product/save")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product newProduct = productService.saveProduct(product);
		
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}

	@GetMapping("/product/all")
	public List<Product> fetchAllProducts() {		
		return productService.getAllProducts();
	}

	@GetMapping("/product/{pId}")
	public ResponseEntity<Object> fetchProductById(@PathVariable("pId") int productId) {
		Product product = productService.getProductById(productId);		
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@DeleteMapping("/product/{pId}")
	public ResponseEntity<String> deleteProductById(@PathVariable("pId") int productId) {
		productService.deleteProduct(productId);
		
		return new ResponseEntity<>("Product Deleted Successfully.", HttpStatus.OK);
	}
	
	@PutMapping("/product/update")
	public ResponseEntity<Product> modifyProduct(@RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(product);
	
		return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
	}
}
