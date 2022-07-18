package com.bejin.spring.authentication;

import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class AppMain  {
	
	private final org.slf4j.Logger LOG = LoggerFactory.getLogger(getClass());
	
	
	public static void main(String[] args)
	{
	   SpringApplication.run(AppMain.class, args);
	}

	@Bean
	  public List<User> run(String... strings) {
	    
	    return Arrays.asList(new User("Bejin", 2000),new User("Tina", 29000),new User("Joe", 550));

	   
	  }

}
