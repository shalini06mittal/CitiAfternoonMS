package com.techgatha.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgatha.dto.OrderResponseDTO;
import com.techgatha.model.BookOrder;
import com.techgatha.repository.BookOrderRepository;

@RestController
@RequestMapping("/orders")
public class BookOrderResource {

	@Autowired
	BookOrderRepository repository;

	
	@GetMapping("/{email}")
	public List<BookOrder> getBooksOrderedByUser(@PathVariable String email)
	{
		List<BookOrder> orders = new ArrayList<>();
		return repository.findByEmail(email).stream()
				.map(order -> 
				{
					BookOrder obj = new BookOrder();
					obj.setOrderno(order.getOrderno());
					obj.setBookid(order.getBookid());
					obj.setDatetime(order.getDatetime());
					return obj;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/dto/{email}")
	public OrderResponseDTO getBooksOrderedByUserDTO(@PathVariable String email)
	{
		List<BookOrder> orders = new ArrayList<>();
		orders = repository.findByEmail(email).stream()
				.map(order -> 
				{
					BookOrder obj = new BookOrder();
					obj.setOrderno(order.getOrderno());
					obj.setBookid(order.getBookid());
					obj.setDatetime(order.getDatetime());
					return obj;
		}).collect(Collectors.toList());
		OrderResponseDTO dto = new OrderResponseDTO();
		dto.setOrders(orders);
		return dto;
	}
	
}
