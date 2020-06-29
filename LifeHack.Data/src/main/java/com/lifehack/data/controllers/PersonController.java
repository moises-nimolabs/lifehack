package com.lifehack.data.controllers;

import com.lifehack.data.entities.Goal;
import com.lifehack.data.entities.Person;
import com.lifehack.data.repositories.GoalRepository;
import com.lifehack.data.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.util.HashSet;
import java.util.Optional;

/***
 * Handles the Person and his Goal relationships.
 */
@RestController
public class PersonController {

    protected PersonRepository personRepository;
    protected GoalRepository goalRepository;

    @Autowired
    public PersonController(PersonRepository personRepository, GoalRepository goalRepository) {
        this.personRepository = personRepository;
        this.goalRepository = goalRepository;
    }

    /***
     * Tries to find a Person by the name.
     * @param name A string containing specific person name
     * @return A person or null if not found
     */
    @GetMapping(value = "/person/", produces = {"application/json"})
    public Person get(@RequestParam String name) {
        return personRepository.findByName(name).orElse(null);
    }

    /***
     * By using a Person model, it'll try to search for an existing one.
     * If it finds it, it'll just update the person and it's relationships.
     * @param person the Model
     * @return the saved Person model
     * @throws InvalidObjectException if the goal doesn't exist or if the person has already a specific goal
     */
    @PostMapping(value = "/person/", produces = {"application/json"})
    public Person post(@RequestBody Person person) throws InvalidObjectException {

        Person found = get(person.name);
        if (found == null) {
            found = new Person();
            found.name = person.name;
        }

        Person existing = found;
        if (existing.goals == null) {
            existing.goals = new HashSet<>();
        }
        for (Goal g : person.goals) {
            Optional<Goal> goal = goalRepository.findById(g.id);
            if (!goal.isPresent()) {
                throw new InvalidObjectException("Invalid goal!");
            }
            existing.goals.add(goal.get());
        }
        personRepository.delete(existing);
        existing.id = null;
        personRepository.save(existing);
        return existing;
    }
}
