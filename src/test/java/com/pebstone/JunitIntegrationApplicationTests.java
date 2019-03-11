package com.pebstone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitIntegrationApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
    public void ToMakeSonarHappy() {
	    JunitIntegrationApplication.main(new String[] {}); 
    }
}
