package com.aop.aspect.container;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;

import com.aop.model.Person;
import com.aop.service.PersonService;

public class PointcutContainer {

//	@Pointcut("execution(* com.aop.*.*Service.find*(..))")
//	public void findPointCount(JoinPoint joinPoint) {}
	@Pointcut("execution(* com.aop.*.*Service.*(..))")
	public void savePointCount() {}
	@Pointcut("execution(* com.aop.service.PersonService.create*(..)) && args(p) && target(service)")
	public void testPointCut(PersonService service, Person p) {}
	@Pointcut("execution(* com.aop.*.*Service.*(..)) && args(p) && target(service)")
	public void savePointCountDemo(Person p, PersonService service) {}
	
}
