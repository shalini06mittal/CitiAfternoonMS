package com.citi.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class SpringCloudGatewayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayDemoApplication.class, args);
	}
	
	@Bean
	RouteLocator configureRoute(RouteLocatorBuilder builder)
	{
		 return builder.routes()
			.route("producer", r->r.path("/hello")
					
					.uri("lb://REST-PRODUCER"))
			.build();
	}

	  
}