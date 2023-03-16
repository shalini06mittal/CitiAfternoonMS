package com.citi.ms;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// security, web, devtools
@RestController
public class MyRestController {

	@GetMapping("user")
	public String greetUser(Principal p)
	{
		return "Hey user "+p.getName()+" welcome here";
	}
	@GetMapping()
	public String plainText()
	{
		return "Just some text";
	}
	@GetMapping("admin")
	public String greetAdmin(Principal p)
	{
		return "Hey ADMIN "+p.getName()+" welcome here";
	}
	@GetMapping("guest")
	public String greetGuest()
	{
		return "Hey Guest welcome here";
	}
}
