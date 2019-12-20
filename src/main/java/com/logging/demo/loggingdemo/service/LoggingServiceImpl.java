/**
 * 
 */
package com.logging.demo.loggingdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


/**
 * @author Sumanth
 *
 */
@Service
public class LoggingServiceImpl implements LoggingService{
	
	public static final Logger LOG = LoggerFactory.getLogger(LoggingServiceImpl.class);
	
	@Autowired
	SampleService sampleService;

	@Override
	@HystrixCommand(fallbackMethod = "callFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100000")}, ignoreExceptions = Exception.class)
	public String hello() {
		
		LOG.info("Calling logging service INFO name: {}", "Sumanth");
		LOG.debug("Calling logging service DEBUG");
		LOG.error("Calling logging service ERROR");
		return "Hello Sumanth";
	}
	
	 private String callFallback() {
	        return null;
	    }

}
