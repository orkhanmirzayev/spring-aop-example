package com.aop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aop.model.Person;
import com.aop.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person createNewPerson(Person p) {
		return personRepository.save(p);
	}

	@Override
	public Person findById(Long id) {
		return personRepository.findOne(id);
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

}
