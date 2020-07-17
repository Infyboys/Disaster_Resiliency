package com.ib.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"com.ib.manager.controller","com.ib.manager.APIcontroller","com.ib.manager.DAO","com.ib.manager.NYTBeans"})
public class Application extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
	}

}
