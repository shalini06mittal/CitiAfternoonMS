package com.citi.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
public class CurrencyMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyMicroserviceApplication.class, args);
	}

//	@Bean
//	@LoadBalanced
//	RestTemplate tempalte()
//	{
//		return new RestTemplate();
//	}
}
