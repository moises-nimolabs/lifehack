package com.lifehack.data.repositories;

import com.lifehack.data.entities.GoalNodeEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

@Service
public interface GoalRepository extends Neo4jRepository<GoalNodeEntity, Long> {

}
