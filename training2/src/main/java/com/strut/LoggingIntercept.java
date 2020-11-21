package com.strut;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoggingIntercept extends AbstractInterceptor
{
    public String intercept(ActionInvocation ai)
    throws Exception
  {
    	long startTime = System.currentTimeMillis(); // 6:30:00
        System.out.println("Entering log intercepor call");
        String actionResult = ai.invoke();
        long stopTime = System.currentTimeMillis();// 6:30:05
        System.out.println("Exiting log intercepor call , time taken :" + (stopTime - startTime) + " ms");
        return actionResult;
  }
}
