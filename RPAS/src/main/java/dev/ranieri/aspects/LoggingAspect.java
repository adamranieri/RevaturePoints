package dev.ranieri.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	public static int counter = 0;
	
	@Before("logPointCut()")
	public void logInfo() {
		System.out.print("Someone used the application ");
		counter++;
		System.out.println("This many calls have been made : "+  counter);
	}
	
	@After("logPointCut()")
	public void logInfoAfter() {
		System.out.println("I Run after a method is called");
	}
	
	// @Around - completely intercpets a method
	// @AfterThrowing - Runs only if the advised method throws an exception
	// @AfterReturning - Runs only if method returns successfully
	
	// this pointcut expression will apply an advice to every method 
	// in the associate controller
	@Pointcut("execution(* dev.ranieri.controllers.AssociateController.*(..))")
	private void logPointCut() {};
}
