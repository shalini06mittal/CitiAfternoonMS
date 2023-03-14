package com.techgatha.model;

import java.util.List;

public class OrderWrapperDTO {

	private List<OrderWrapper> orders;
	
	private List<String> viewersChoice;

	public List<OrderWrapper> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderWrapper> orders) {
		this.orders = orders;
	}

	public List<String> getViewersChoice() {
		return viewersChoice;
	}

	public void setViewersChoice(List<String> viewersChoice) {
		this.viewersChoice = viewersChoice;
	}

	
	
	
}
