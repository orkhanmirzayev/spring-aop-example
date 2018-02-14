package com.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aop.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
