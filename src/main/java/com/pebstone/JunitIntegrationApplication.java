package com.pebstone;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pebstone.dao.CustomerRepository;
import com.pebstone.model.Customer;

@SpringBootApplication
public class JunitIntegrationApplication {

	private static final Logger log = LoggerFactory.getLogger(JunitIntegrationApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(JunitIntegrationApplication.class, args);
	}
	
}
