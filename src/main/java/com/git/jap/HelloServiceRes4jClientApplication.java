package com.git.jap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HelloServiceRes4jClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloServiceRes4jClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate newTemplate() {
		return new RestTemplate();
	}
}
