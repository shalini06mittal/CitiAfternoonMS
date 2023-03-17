package com.example.demo;

import static org.springframework.http.HttpMethod.GET;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller1 {

	@GetMapping("/ms1/home")
	public String helloMessage()
	{
		return "hello";
	}
	
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    //private final WebClient webClient = WebClient.builder().build();

    @GetMapping("/ms1/hello")
    @ResponseStatus(HttpStatus.OK)
    public String helloRestTemplate() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt.getTokenValue());
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8084/microservice2/home",
                GET,
                new HttpEntity<>(httpHeaders),
                String.class);

        return "hello - message from microservice 2 -  " + exchange.getBody();
    }

//    @GetMapping("/microservice1/home/webclient")
//    @ResponseStatus(HttpStatus.OK)
//    public String helloWebClient() {
//        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        String response = webClient.get()
//                .uri("http://localhost:8084/microservice2/home")
//                .headers(header -> header.setBearerAuth(jwt.getTokenValue()))
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//        return "hello - message from microservice 2 -  " + response;
//    }
}
