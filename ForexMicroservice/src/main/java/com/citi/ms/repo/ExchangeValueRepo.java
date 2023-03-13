package com.citi.ms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citi.ms.entity.ExchangeValue;

@Repository
public interface ExchangeValueRepo 
extends CrudRepository<ExchangeValue, Integer>{
	
	public ExchangeValue 
	findByFromAndTo(String from, String to);
}
