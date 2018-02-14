package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.aop.model.Person;
import com.aop.service.PersonService;

@Aspect
@Component
public class LoggingAspect {

	
	@AfterReturning(returning="person",pointcut="com.aop.aspect.container.PointcutContainer.savePointCountDemo(p,service)")
	public void beforeExecution(Person p, PersonService service, Person person) {
		System.err.println("*****@Before Started*****");
//		final String name = joinPoint.getSignature().getName();
//		final String declaringType = joinPoint.getSignature().getDeclaringType().getName();
//		final String target = joinPoint.getTarget().toString();
		System.err.println("Target--> "+service.toString());
//		System.err.println("Name--> "+name);
		System.err.println("Declaring Type--> "+p.getName());
		System.err.println("*****@Before Finished*****");
		System.out.println("Inserted person id: "+person.getId());
	}
//	
//	@After("execution(* com.aop.service.*Service.*(..))")
//	public void afterExecution(JoinPoint joinPoint) {
//		System.err.println("*****@After Started*****");
//		final String name = joinPoint.getSignature().getName();
//		final String declaringType = joinPoint.getSignature().getDeclaringType().getName();
//		System.err.println("Name--> "+name);
//		System.err.println("Declaring Type--> "+declaringType);
//		System.err.println("*****@After Finished*****");
//	}
//	
//	@Around(value="com.aop.aspect.container.PointcutContainer.findPointCount()")
//	public void afterExecution(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.err.println("*****@Around Started*****");
//		final String name = joinPoint.getSignature().getName();
//		final String declaringType = joinPoint.getSignature().getDeclaringType().getName();
//		System.err.println("Name--> "+name);
//		System.err.println("Declaring Type--> "+declaringType);
//		joinPoint.proceed();
//		System.err.println("*****@Around Finished*****");
//	}
}
