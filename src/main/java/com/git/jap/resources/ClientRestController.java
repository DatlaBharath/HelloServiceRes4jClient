package com.git.jap.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/client")
public class ClientRestController {
	
	private static final String CLIENT_SERVICE = "clientService";
	
	@Autowired
	RestTemplate template;
	
	@GetMapping("/hi")
	@CircuitBreaker(name=CLIENT_SERVICE, fallbackMethod = "callOnFail")
	public String sayHi() {
		String url = "http://localhost:8056/rest/service";
		String output = template.getForObject(url, String.class);
		return output.toString();
	}
	
	public String callOnFail(Exception e) {
		return "call on fail";
	} 
}
