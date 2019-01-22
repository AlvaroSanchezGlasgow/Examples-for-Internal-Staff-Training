package com.test.everis.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class UserAspect {

	private static final Logger logger = LoggerFactory.getLogger(UserAspect.class);
	
	/**
	 * 
	 * @param joinPoint
	 */
	  @Before("execution(* com.test.everis.service.interfaces.UsersService.getAllUsers())")
	public void beforeAdvice(JoinPoint joinPoint) {
		
		System.out.println("================================================================");
		
	    Signature signature = joinPoint.getSignature();
	    String methodName = signature.getName();
	    String stuff = signature.toString();
	    String arguments = Arrays.toString(joinPoint.getArgs());
	    System.out.println("Before handler:" + joinPoint.getSignature()+" - We are just about to call method: "
	        + methodName + " with arguments " + arguments);
	    System.out.println("================================================================");
		System.out.println("Running Everis Example - Before");
	}
	 
	  /**
	   * 
	   * @param jp
	   * @param ex
	   */
	  @AfterThrowing(pointcut = "execution(* com.test.everis.controller.HomeController.*(..))", 
			   throwing = "ex")
	 		  public void throwingExample(JoinPoint jp, Throwable ex) {
		  
		  System.out.println("================================================================");
		  System.out.println("@AfterThrowing Everis Example - @AfterThrowing");
		  System.out.println("EEEXXXXXXXCCCCCCCCCEEEEEEPPPPPPPTTTTIIIIIOOOOOONNNNNNN!!!!!!!!!!");
		  System.out.println("Method Signature: "  + jp.getSignature());  
		   System.out.println("Exception: "+ex);  
		  System.out.println("================================================================");
	  }

	 }
