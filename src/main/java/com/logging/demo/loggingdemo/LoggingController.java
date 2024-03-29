/**
 * 
 */
package com.logging.demo.loggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logging.demo.loggingdemo.service.LoggingService;

/**
 * @author Sumanth
 *
 */

@RestController
public class LoggingController {
	
	public static final Logger LOG = LoggerFactory.getLogger(LoggingController.class);
	
	@Autowired
	LoggingService loggingService;
	
	@GetMapping("/hello")
	public String sayHello() {
		LOG.info("Calling hello controller INFO");
		LOG.debug("Calling hello controller DEBUG");
		LOG.error("Calling hello controller ERROR");
		return loggingService.hello();
	}

}
