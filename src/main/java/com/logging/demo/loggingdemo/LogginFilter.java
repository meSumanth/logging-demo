/**
 * 
 */
package com.logging.demo.loggingdemo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
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
		try {
			Map<String, String> map = new HashMap<>();
			map.put("Request Id", UUID.randomUUID().toString());
			map.put("URL", ((HttpServletRequest) request).getRequestURI());
			map.put("Method", ((HttpServletRequest) request).getMethod());
			System.out.println(":::: "+ThreadLocalUtil.getData());
			ThreadLocalUtil.setData(map);
			MDC.setContextMap(map);
			chain.doFilter(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ThreadLocalUtil.clear();
			MDC.clear();
		}
	}
	

}
