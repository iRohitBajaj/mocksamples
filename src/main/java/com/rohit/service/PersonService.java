package com.rohit.service;

import com.rohit.controller.ResourceNotFoundException;
import com.rohit.model.Person;
import com.rohit.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonService {

    PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAllPersons(){
        return repository.findAll();
    }

    public Person addPerson(Person person){
        person.setHeight(person.getHeight()+2);
        return repository.save(person);
    }

    public Optional<Person> getPersonByName(String name){
        return repository.findById(name);
    }

    public void deletePerson(String name){
        Person person = repository.findById(name)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "name", name));

        repository.delete(person);
    }
}
