/**
 * 
 */
package com.logging.demo.loggingdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Sumanth
 *
 */
@Service
public class SampleService {
	
	public static final Logger LOG = LoggerFactory.getLogger(SampleService.class);
	
	public void test() {
		LOG.info("test info");
		LOG.debug("test DEBUG");
		LOG.error("test error");
	}

}
