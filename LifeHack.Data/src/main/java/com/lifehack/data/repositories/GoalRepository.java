package com.lifehack.data.repositories;

import com.lifehack.data.entities.Goal;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface GoalRepository extends Neo4jRepository<Goal, Long> {
    @Query("MATCH(target:Goal{sequence:$sequence}) return target, [ (target)-[c:Path*]->(child:Goal) | [c, child] ]")
    Optional<Goal> findBySequence(Integer sequence);
}
