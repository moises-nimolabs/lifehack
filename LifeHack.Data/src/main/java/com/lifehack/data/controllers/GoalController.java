package com.lifehack.data.controllers;

import com.lifehack.data.entities.Goal;
import com.lifehack.data.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * Queries the Goals.
 * By default the Goals aren't interchangeable.
 */
@RestController
public class GoalController {

    protected GoalRepository goalRepository;

    @Autowired
    public GoalController(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @GetMapping(value = "/goal/", produces = {"application/json"})
    public Goal get(@RequestParam Integer id) {
        Goal response = goalRepository.findBySequence(1).get();
        return response;
    }
}
