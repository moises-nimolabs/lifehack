package com.lifehack.data.controllers;

import com.lifehack.data.entities.PersonNodeEntity;
import com.lifehack.data.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    protected  PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person/")
    public PersonNodeEntity get(@RequestParam Long id) {
        return personRepository.findById(id).get();
    }

}
