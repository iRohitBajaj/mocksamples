package com.rohit.controller;

import com.rohit.model.Person;
import com.rohit.service.PersonService;
import com.sun.tools.javap.TypeAnnotationWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController{

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping("/persons/{name}")
    public Person getPersonById(@PathVariable(value = "name") String name) {
        return personService.getPersonByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "Name", name));
    }


    @DeleteMapping("/persons/{name}")
    public ResponseEntity<?> deletePerson(@PathVariable(value = "name") String name) {

        personService.deletePerson(name);
        return ResponseEntity.ok().build();
    }
}
