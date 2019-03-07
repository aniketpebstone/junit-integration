package com.pebstone;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.pebstone.controller.CustomerController;

import com.pebstone.model.Customer;
import com.pebstone.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private CustomerService service;
        
    
    @Test
    public void givenCustomer_whenGetCustomers_thenReturnJsonArray()
      throws Exception {
         
    	Customer aniket = new Customer("Aniket","Paranjpe");
        List<Customer> allCustomers = Arrays.asList(aniket);
     
        when(service.findByLastName(aniket.getLastName())).thenReturn(allCustomers);
    
        mvc.perform(get("/name?lastName=Paranjpe")
          .contentType(MediaType.APPLICATION_JSON))
          .andDo(print())
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("Aniket")))
          .andExpect(content().string(containsString("Paranjpe")));
    }
    
}
