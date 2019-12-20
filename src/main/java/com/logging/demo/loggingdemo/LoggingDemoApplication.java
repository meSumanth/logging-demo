package com.logging.demo.loggingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;

import com.netflix.hystrix.strategy.HystrixPlugins;

@SpringBootApplication
@ComponentScan("com.logging.demo.*")
@EnableCircuitBreaker
public class LoggingDemoApplication {

	public static void main(String[] args) {
		HystrixPlugins.getInstance().registerCommandExecutionHook(new HystrixHook());
		SpringApplication.run(LoggingDemoApplication.class, args);
		
		
	}
	
}
