package com.techgatha.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgatha.model.Book;
import com.techgatha.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookResource {

	@Autowired
	private BookRepository repository;
	
	@GetMapping("/{bookid}")
	public Book getBook(@PathVariable String bookid) throws Exception
	{
//		if(bookid.equals("B1"))
//			throw new Exception();
		return repository.findById(bookid).get();
	}
}
