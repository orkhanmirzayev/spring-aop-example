package com.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.config.AopConfig;
import com.aop.model.Person;
import com.aop.repository.PersonRepository;
import com.aop.service.PersonService;
import com.aop.service.PersonServiceImpl;

public class AppTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		PersonService repo = context.getBean(PersonServiceImpl.class);
		Person p = new Person();
		p.setAge(29);
		p.setName("Orkhan");
		repo.createNewPerson(p);
		System.out.println("Ok");
	}
}
