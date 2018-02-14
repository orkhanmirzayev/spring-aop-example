package com.aop.service;

import java.util.List;

import com.aop.model.Person;

public interface PersonService {

	Person createNewPerson(Person p);
	Person findById(Long id);
	List<Person> findAll();
}
