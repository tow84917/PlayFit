package com.java016.playfit.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	// logger
	private Logger myLogger = LoggerFactory.getLogger(LoggingAspect.class);
	
	// pointcut Controller (package內任何 回傳型態、類別、方法、參數)
	@Pointcut("execution(* com.java016.playfit.controller.*.*(..))")
	private void forControllerPackage() {
		 
	}
	
	// pointcut Dao && Service
	@Pointcut("execution(* com.java016.playfit.com.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.java016.playfit.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	// 結合上面三者
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
		
	}
	
	// @before advice 方法執行前
	@Before("forAppFlow()") 
	private void before(JoinPoint joinPoint) {
		
		// display 呼叫方法
		String method = joinPoint.getSignature().toShortString();
		
		// display 呼叫方法之參數
		Object[] args = joinPoint.getArgs();
		
		String argString = "";
			
		int count = 0 ;
		
		for(Object arg : args) {
				if (arg != null) {
					argString += String.valueOf(arg) ;
					count ++ ;
					if (count < args.length) {
						argString += ", " ;				
				}
			}
		}
		
		
//		myLogger.info("Calling method : " + method + ", args : (" + argString.toString() + ")");
//		System.out.println("Calling method : " + method + ", args : (" + argString + ")");
	}
	
	// @AfterReturning advice 
	// @AfterReturning 成功, @AfterThrowing 失敗, @After = finally
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "result" // Object result
			)
	private void afterReturning(JoinPoint joinPoint, Object result) {
		
		// display 已 return 方法
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info("Return method : " + method + ", result : " + result);
//		System.out.println("Return from method : " + method + ", result : " + result);
		
	}
	
}
















