package com.logging.demo.loggingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.logging.demo.loggingdemo")
public class LoggingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingDemoApplication.class, args);
	}

}
