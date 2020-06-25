package com.lifehack.data.repositories;

import com.lifehack.data.entities.PersonNodeEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

@Service
public interface PersonRepository extends Neo4jRepository<PersonNodeEntity, Long> {

}
