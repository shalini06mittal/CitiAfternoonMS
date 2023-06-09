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
	
	@GetMapping("/ms2")
	public String microservice1()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return template.getForObject("http://MS3/ms3", String.class);
	}
}
