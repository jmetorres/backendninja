package com.udemy.backendninja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackendninjaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BackendninjaApplication.class, args);
	}
}
