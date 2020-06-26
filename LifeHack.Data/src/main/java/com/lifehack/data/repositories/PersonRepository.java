package com.lifehack.data.repositories;

import com.lifehack.data.entities.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query("MATCH(p:Person{name:$name}) RETURN p")
    Optional<Person> findByName(String name);
}
