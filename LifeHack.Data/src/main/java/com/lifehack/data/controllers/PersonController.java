package com.lifehack.data.controllers;

import com.lifehack.data.entities.Person;
import com.lifehack.data.repositories.PersonRepository;
import com.sun.deploy.perf.PerfRollup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PersonController {

    protected PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person/")
    public Person get(@RequestParam String name) {
        return personRepository.findByName(name).orElse(null);
    }


    @PostMapping("/person/")
    public Person post(Person person) {

        Person existing = get(person.name);



        return person;

    }
}
