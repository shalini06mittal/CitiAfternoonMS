package com.citi.ms;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestControllerMS1 {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/ms3")
	public String microservice1()
	{
		throw new RuntimeException();
	}
}
