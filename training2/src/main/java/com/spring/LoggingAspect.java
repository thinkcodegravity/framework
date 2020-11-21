package com.spring;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggingAspect  {
	
	
	@Pointcut("within(com.spring.ProfileBean)")
	public void getResponseTime(ProceedingJoinPoint  joinPoint) throws Exception{
		// ******************** SECURITY *************************
		String remoteAddress = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes())
			       .getRequest().getRemoteAddr();
		if(remoteAddress.equals("1.2.3.4")) {
			System.out.println("client is blocked for security reason");
			throw new Exception("Blocked Customer");
		}
		
		// ******************** LOGGING *************************		
		System.out.println("\n\n >>>>>>>>>>> SPRING ENTER >>>>>>>>>>>");
		System.out.println(" Entering Aspect - response time performance");
		
		// ******************** PERFORMANCE MONITOR *************************		
		long startTime=System.currentTimeMillis();
		
		// ******************** EXCEPTION HANDLING *************************		
		try {
			joinPoint.proceed();// give control to bean class
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long stopTime=System.currentTimeMillis();
		System.out.println("Time taken to process this request :"+(stopTime-startTime)+"ms");
		System.out.println("Exit Aspect -     response time performance");
		System.out.println(">>>>>>>>>>> SPRING EXIT >>>>>>>>>>>");
		
	}
	/*
	@Before("pointcut1()")
	public Object advice1(ProceedingJoinPoint  joinPoint){
			.....code....
	}
	@Before("pointcut1()") // apply point cut
	public Object advice1(ProceedingJoinPoint  joinPoint){
			.....code....
	}
	@Pointcut("within(com.spring.beans.ProfileBean)")
	public void pointcut1(){ }
	 */
	
}
