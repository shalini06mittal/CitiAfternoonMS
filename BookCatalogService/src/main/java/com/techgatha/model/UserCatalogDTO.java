package com.techgatha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class UserCatalogDTO {


	private String title;
	private String description;
	private double price;
	private String datetime;
	
	public UserCatalogDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserCatalogDTO( String booktitle, String bookdescription, double price, String datetime) {
		super();

		this.title = booktitle;
		this.description = bookdescription;
		this.price = price;
		this.datetime = datetime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String booktitle) {
		this.title = booktitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String bookdescription) {
		this.description = bookdescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

//	@Override
//	public String toString() {
//		return "UserCatalog [email=" + email + ", booktitle=" + title + ", bookdescription=" + description
//				+ ", price=" + price + ", datetime=" + datetime + "]";
//	}
	
}
