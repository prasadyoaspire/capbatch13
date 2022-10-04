package com.abc.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.entity.Product;
import com.abc.ecom.model.LoginRequest;
import com.abc.ecom.model.LoginResponse;
import com.abc.ecom.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.addCustomer(customer);
		
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<Customer> fetchAllCustomers() {		
		return customerService.getAllCustomers();
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> fetchCustomerById(@PathVariable("customerId") int customerId) {
		Customer customer = customerService.getCustomerById(customerId);		
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> doCustomerLogin(@RequestBody LoginRequest loginRequest) {
		Customer customer = customerService.customerLogin(loginRequest.getUsername(), loginRequest.getPassword());
		
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setId(customer.getId());
		loginResponse.setFirstName(customer.getFirstName());
		loginResponse.setLastName(customer.getLastName());
		
		return new ResponseEntity<>(loginResponse, HttpStatus.OK);
	}
}
