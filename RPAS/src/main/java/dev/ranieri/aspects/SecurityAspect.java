package dev.ranieri.aspects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class SecurityAspect {
	
	
	@Before("securityPointCut()")
	public void showAuthorized() {
		System.out.println("You called an authorized method");
	}
	
	@Around("securityPointCut()")
	// you are passing in the method you are calling
	public Object authorize(ProceedingJoinPoint pjp) throws Throwable {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
		
		String auth = request.getHeader("Authorization");
		
		if(auth != null && auth.equals("pa$$word")) {
			Object obj = pjp.proceed(); 
			// allow method I am advising to execute and return that method
			// to the call stack to continue regular execution
			return obj;
		}else {
			response.sendError(401);
			return null;
		}
		

	}
	
	@Pointcut("@annotation(dev.ranieri.aspects.Authorized)")
	private void securityPointCut() {};

}
