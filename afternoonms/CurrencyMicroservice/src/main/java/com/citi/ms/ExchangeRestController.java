package com.citi.ms;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExchangeRestController {

	@GetMapping("/exchange/from/{from}/to/{to}/qty/{qty}")
	public ExchangeValue getConversionMultiples(@PathVariable String from,
			@PathVariable String to,
			@PathVariable int qty)
	{
		RestTemplate template = new RestTemplate();
//		ExchangeValue ob =
//		template.getForObject("http://localhost:8081/forex/from/{from}/to/{to}",
//				ExchangeValue.class, from, to);
		/**
		 * 1. RestTemplate object creation
		 * 2. localhost:8081 => cloud [ IP addresses dynamic ]
		 * 3. service to communicate without developers 
		 * 4. how locate ? unique id
		 * 5. someone make service comunication, discoverable
		 * 
		 * Server => managing ms, making them discoverable, health,
		 * load balancing
		 * discovery server => eureka
		 */
		
		ResponseEntity<ExchangeValue> resp =
		template.getForEntity("http://uniqueid/forex/from/{from}/to/{to}",
				ExchangeValue.class, from, to);
		System.out.println(resp.getStatusCode());
		ExchangeValue ob = resp.getBody();
		ob.setTotal(ob.getConversionMultiple().multiply(new BigDecimal(qty)));
		return ob;
	}
	
	
}
