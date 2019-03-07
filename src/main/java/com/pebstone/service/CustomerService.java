package com.pebstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pebstone.dao.CustomerRepository;
import com.pebstone.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findByLastName(String lastName){
		List<Customer> customers=customerRepository.findByLastName(lastName);
		return customers;
	}
}
