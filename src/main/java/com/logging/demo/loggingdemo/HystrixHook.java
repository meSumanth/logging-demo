package com.logging.demo.loggingdemo;

import java.util.Map;

import org.slf4j.MDC;

import com.netflix.hystrix.HystrixInvokable;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;

public class HystrixHook extends HystrixCommandExecutionHook {

    private HystrixRequestVariableDefault<Map<String, String>> data = new HystrixRequestVariableDefault<>();

    @Override
    public <T> void onStart(HystrixInvokable<T> commandInstance) {
    	System.out.println("START:: "+ MDC.getCopyOfContextMap());
        HystrixRequestContext.initializeContext();
        getThreadLocals();
    }

    @Override
    public <T> void onExecutionStart(HystrixInvokable<T> commandInstance) {
    	System.out.println("EXEC:: "+ MDC.getCopyOfContextMap());
        setThreadLocals();
		MDC.setContextMap(data.get());
    }


    @Override
    public <T> void onFallbackStart(HystrixInvokable<T> commandInstance) {
        setThreadLocals();
    }
  
  
    @Override
    public <T> void onSuccess(HystrixInvokable<T> commandInstance) {
        HystrixRequestContext.getContextForCurrentThread().shutdown();
        MDC.clear();
        System.out.println("SUC:: "+ MDC.getCopyOfContextMap());
        super.onSuccess(commandInstance);
    }

    @Override
    public <T> Exception onError(HystrixInvokable<T> commandInstance, HystrixRuntimeException.FailureType failureType, Exception e) {
        HystrixRequestContext.getContextForCurrentThread().shutdown();
        MDC.clear();
        System.out.println("ERR:: "+ MDC.getCopyOfContextMap());
        return super.onError(commandInstance, failureType, e);
    }
  
    private void getThreadLocals() {
        data.set(ThreadLocalUtil.getData());
    }

    private void setThreadLocals() {
        ThreadLocalUtil.setData(data.get());
    }
}