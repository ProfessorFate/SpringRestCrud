package com.example.springbootrestcrud.controller;


import com.example.springbootrestcrud.model.Person;
import com.example.springbootrestcrud.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private PersonServiceImpl personService;

    @Autowired
    public MainController(PersonServiceImpl personService){
        this.personService=personService;
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getPerson(){
        List<Person> personList = personService.getAll();
        if (personList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Person> findPersonById(@PathVariable("id") Integer personId ){
        if(personId== null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person=personService.getById(personId);
        if (personId==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        if(person==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        personService.save(person);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> update(@RequestBody Person person){
        if(person==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        personService.save(person);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable int id){
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
