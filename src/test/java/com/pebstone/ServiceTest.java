package com.pebstone;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.pebstone.dao.CustomerRepository;
import com.pebstone.model.Customer;
import com.pebstone.service.CustomerService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Configurations.class)
public class ServiceTest {

	@Autowired
    private CustomerService customerService;
	@MockBean
    private CustomerRepository customerRepository;
	
	@Before
	public void setUp() {
	    Customer aniket = new Customer("Aniket","Paranjpe");
	    List<Customer> customers=new ArrayList<>();
	    customers.add(aniket);
	    Mockito.when(customerRepository.findByLastName(aniket.getLastName()))
	      .thenReturn(customers);
	}
	@Test
	public void whenValidName_thenCustomerShouldBeFound() {
	    String lastName = "Paranjpe";
	    System.out.println("yyy");
	    List<Customer> found = customerService.findByLastName(lastName);
	     assertThat(((Customer)found.get(0)).getLastName()).isEqualTo(lastName);
	 }
}
