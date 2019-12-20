package com.logging.demo.loggingdemo;

import java.util.Map;
import java.util.concurrent.Callable;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;

public class ConcurrencyStrategy extends HystrixConcurrencyStrategy {
	
	 @Override
	    public <T> Callable<T> wrapCallable(Callable<T> callable) {
	        Map id = ThreadLocalUtil.getData();
	        try {
	            return () -> {
	                ThreadLocalUtil.setData(id);
	                T result = callable.call();
	                ThreadLocalUtil.clear();
	                return result;
	            };
	        } finally {}
	    }
	 
	 void test() {
		 
	 }

}


