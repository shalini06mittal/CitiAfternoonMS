package com.techgatha.cb.HystrixCircuitBreakerDemo;

import com.techgatha.cb.HystrixCircuitBreakerDemo.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;
@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class HystrixCircuitBreakerDemoApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(HystrixCircuitBreakerDemoApplication.class, args);
		MyService myService = ctx.getBean(MyService.class);

		System.out.println("-- calling doSomething(1) 40 times --");
		Thread.sleep(5000);
		
		System.out.println("\n******* 1 **********");
		myService.doSomething(0); // 1
		Thread.sleep(1000);
		
		System.out.println("\n******* 2 **********");
		myService.doSomething(1); // 1
		Thread.sleep(1000);
		
		System.out.println("\n******* 3 **********");
		myService.doSomething(0); // 1
		Thread.sleep(1000);
		
		System.out.println("\n******* 4 **********");
		myService.doSomething(1); // 1
		Thread.sleep(1000);
		
		System.out.println("\n******* 5 **********");
		myService.doSomething(1); // 1
		Thread.sleep(1000);
		
		System.out.println("\n******* 6 **********");
		myService.doSomething(0); // 1
		Thread.sleep(1000);
		
		System.out.println("\n******* 7 **********");
		myService.doSomething(1); // 1
		Thread.sleep(1000);
		
		
		
		
		
//		int n = 40;
//		for (int i = 0; i < n; i++) {
//			System.out.println("******* "+i +" **************");
//			myService.doSomething(i < (n * 0.6) ? 0 : 2);// 10/0
//			TimeUnit.MILLISECONDS.sleep(100);
//		}
//		TimeUnit.SECONDS.sleep(6);
//
//		System.out.println("-- final call --");
//		myService.doSomething(2);
		
		
	}

}
