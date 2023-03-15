package com.citi.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MyService {

	@Autowired
	private RestTemplate template;
	
	@HystrixCommand(fallbackMethod = "getMessageFallback")
	public String getMessage(String username)
	{
		return template.getForObject("http://REST-PRODUCER/greetex", String.class, username);
	}
	
	public String getMessageFallback(String username)
	{
		return "Hey Guest";
	}
}
