package com.citi.ms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="FOREX-SERVICE")
public interface ForexFeignClient {

	@GetMapping("/forex/from/{from}/to/{to}")
	public ExchangeValue getConversionMultiples(@PathVariable String from,
			@PathVariable String to);
}
