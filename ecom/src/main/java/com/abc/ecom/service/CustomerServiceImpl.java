package com.abc.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.exception.AuthenticationFailureExcepiton;
import com.abc.ecom.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {	
		
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer is not existing with id: "+customerId);
		}
		
		return optionalCustomer.get();
	}

	@Override
	public Customer customerLogin(String username, String password) {
		
		Optional<Customer> optionalCustomer = customerRepository.findByUsername(username);
		
		if(optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Username is not existing.");
		}
		
		Customer customer = optionalCustomer.get();
		
		if(!password.equals(customer.getPassword()) ) {
			
			throw new AuthenticationFailureExcepiton("Invalid Password.");
		}		
		
		return customer;
	}

}
