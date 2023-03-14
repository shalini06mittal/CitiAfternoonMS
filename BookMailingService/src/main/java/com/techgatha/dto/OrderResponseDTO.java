package com.techgatha.dto;

import java.util.Arrays;
import java.util.List;

import com.techgatha.model.BookOrder;

public class OrderResponseDTO {

	List<BookOrder> orders ;
	List<String> viewersChoice =
			Arrays.asList("b10","b11","b12");
	
	
	public List<BookOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<BookOrder> orders) {
		this.orders = orders;
	}
	public List<String> getViewersChoice() {
		return viewersChoice;
	}
	public void setViewersChoice(List<String> viewersChoice) {
		this.viewersChoice = viewersChoice;
	}
	
	
}
