package com.citi.ms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MyRestController {

	@Value("${msg: something is wrong, unable to read from config server}")
	private String message;
	
	@GetMapping("/msg")
	public String readMessage()
	{
		return this.message;
	}
}
