package com.example.springbootrestcrud.service;

import com.example.springbootrestcrud.model.Person;

import java.util.List;

public interface PersonService {

    Person getById(int id);

    void save (Person person);

    void delete(int id);

    List<Person> getAll();



}
