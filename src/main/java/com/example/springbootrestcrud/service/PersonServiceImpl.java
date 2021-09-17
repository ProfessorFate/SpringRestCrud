package com.example.springbootrestcrud.service;
import com.example.springbootrestcrud.model.Person;
import com.example.springbootrestcrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository=personRepository;
    }


    @Override
    public Person getById(int id) {
        return personRepository.findById(id).get();
    }


    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(int id) {
    personRepository.deleteById(id);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
