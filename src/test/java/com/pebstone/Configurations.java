package com.pebstone;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.pebstone.service.CustomerService;

@TestConfiguration
public class Configurations {
	@Bean
    public CustomerService customerService() {
        return new CustomerService();
    }
}
