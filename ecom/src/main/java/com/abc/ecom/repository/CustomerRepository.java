package com.abc.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	Optional<Customer> findByUsername(String username);

}
