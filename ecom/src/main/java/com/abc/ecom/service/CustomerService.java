package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.entity.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(int customerId);
	
	Customer customerLogin(String username, String password);
	
	

}
