package com.pebstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pebstone.model.Customer;
import com.pebstone.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService CustomerService;
	
	@RequestMapping("/")
	public String healthCheck() {
		return "OK";
	}
	@RequestMapping("/name")
    public List<Customer> getCustomers(@RequestParam(value="lastName", defaultValue="Bauer") String name) {
        List<Customer> customers=CustomerService.findByLastName(name);
        System.out.println("Customers:"+customers);
        return customers;
    }	
}
