/**
 * 
 */
package com.logging.demo.loggingdemo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;

/**
 * @author Sumanth
 *
 */

@Component
public class LogginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		MDC.clear();
		MDC.put("requestId", System.currentTimeMillis());
		MDC.put("method", "GET");
		chain.doFilter(request, response);
		MDC.clear();
	}
	

}
