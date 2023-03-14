package com.citi.ms;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


// https://github.com/shalini06mittal/CitiAfternoonMS

@RestController
public class ExchangeRestController {

	
//	@Autowired
//	private RestTemplate template;
//	
//	@GetMapping("/exchange/from/{from}/to/{to}/qty/{qty}")
//	public ExchangeValue getConversionMultiples(@PathVariable String from,
//			@PathVariable String to,
//			@PathVariable int qty)
//	{
//		ResponseEntity<ExchangeValue> resp =
//		template.getForEntity("http://FOREX-SERVICE/forex/from/{from}/to/{to}",
//				ExchangeValue.class, from, to);
//		System.out.println(resp.getStatusCode());
//		ExchangeValue ob = resp.getBody();
//		ob.setTotal(ob.getConversionMultiple().multiply(new BigDecimal(qty)));
//		return ob;
//	}
	
	@Autowired
	private ForexFeignClient feignClient;
	
	@GetMapping("/exchange/from/{from}/to/{to}/qty/{qty}")
	public ExchangeValue getConversionMultiples(@PathVariable String from,
			@PathVariable String to,
			@PathVariable int qty)
	{
		ExchangeValue ob = feignClient.getConversionMultiples(from, to);
		ob.setTotal(ob.getConversionMultiple().multiply(new BigDecimal(qty)));
		return ob;
	}
	
	
}
