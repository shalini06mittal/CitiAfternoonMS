package com.citi.ms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	
	@GetMapping("/greet/{username}")
	public String greet(@PathVariable String username) throws InterruptedException
	{
		System.out.println("........Waiting....");
		Thread.sleep(10000);
		System.out.println(".......wait end.........");
		return "Hello "+username;
	}
	
	@GetMapping("/greetex")
	public String greetException(@RequestParam(required = false) String username) throws Exception 
	{
		
		System.out.println(username);
		if(username != null)
			return "Hey!!! No exception";
		
		throw new Exception("Please contact admin");
		

	}
}
