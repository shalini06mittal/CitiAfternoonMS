package com.techgatha.model;

import java.util.List;

public class UserCatalogResponse {
	
	List<UserCatalogDTO> catalog;
	String email;
	List<String> favMovies;
	
	public List<UserCatalogDTO> getCatalog() {
		return catalog;
	}
	public void setCatalog(List<UserCatalogDTO> catalog) {
		this.catalog = catalog;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getFavMovies() {
		return favMovies;
	}
	public void setFavMovies(List<String> favMovies) {
		this.favMovies = favMovies;
	}
	
	
	
}
