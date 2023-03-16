package com.techgatha.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techgatha.model.OrderWrapper;
import com.techgatha.model.OrderWrapperDTO;

@FeignClient(name="GATEWAY-SERVER")
public interface BookOrderFeignClient {

	
	@GetMapping("/orders/{email}")
	public List<OrderWrapper> getBookOrderDetails( @PathVariable String email);
	
	@GetMapping("/orders/dto/{email}")
	public OrderWrapperDTO getBookOrderDetailsDTO( @PathVariable String email);
}
