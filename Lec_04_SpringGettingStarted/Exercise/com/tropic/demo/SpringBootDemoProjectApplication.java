package com.tropic.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// This annotation includeds @ComponentScan which scans all the bytecodes for the classes found in this package
@SpringBootApplication
public class SpringBootDemoProjectApplication {

	public static void main(String[] args) {

		// With this line of code we have access to IoC container
		ApplicationContext context = SpringApplication.run(SpringBootDemoProjectApplication.class, args);

		// We are getting the class from IoC
		Alien alien = context.getBean(Alien.class);
		alien.code();
	}

}