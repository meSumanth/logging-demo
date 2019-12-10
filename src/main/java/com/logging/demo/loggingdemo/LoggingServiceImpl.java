/**
 * 
 */
package com.logging.demo.loggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Sumanth
 *
 */
@Service
public class LoggingServiceImpl implements LoggingService{
	
	public static final Logger LOG = LoggerFactory.getLogger(LoggingServiceImpl.class);

	@Override
	public String hello() {
		LOG.info("Calling logging service");
		return "Hello Sumanth";
	}

}
