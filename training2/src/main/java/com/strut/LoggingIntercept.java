package com.strut;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoggingIntercept extends AbstractInterceptor
{
	Logger log=Logger.getLogger("LoggingIntercept"); 
    
    public String intercept(ActionInvocation ai)
    throws Exception
  {
		System.out.println("\n\n >>>>>>>>>>> STRUT ENTER >>>>>>>>>>>");
		System.out.println(" Entering strut interceptor program");
    	long startTime = System.currentTimeMillis(); // 6:30:00
        System.out.println("Entering log intercepor call");
        String actionResult = ai.invoke();
        long stopTime = System.currentTimeMillis();// 6:30:05
        System.out.println("Exiting strut intercepor call , time taken :" + (stopTime - startTime) + " ms");
		System.out.println(" >>>>>>>>>>> STRUT EXIT >>>>>>>>>>>");
		return actionResult;
  }
}
