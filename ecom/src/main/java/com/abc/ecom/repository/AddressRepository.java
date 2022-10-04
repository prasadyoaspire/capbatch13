package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
