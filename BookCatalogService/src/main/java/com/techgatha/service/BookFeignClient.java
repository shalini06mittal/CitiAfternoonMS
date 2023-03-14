package com.techgatha.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techgatha.model.UserCatalog;
import com.techgatha.model.UserCatalogDTO;

@FeignClient(name="BOOK-SERVICE")
public interface BookFeignClient {

	
	@GetMapping("/books/{bookid}")
	public UserCatalog getBookDetails( @PathVariable String bookid);
	
	@GetMapping("/books/{bookid}")
	public UserCatalogDTO getBookDetailsDTO( @PathVariable String bookid);
}
