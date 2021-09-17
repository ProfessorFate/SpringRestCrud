package com.example.springbootrestcrud.repository;

import com.example.springbootrestcrud.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
