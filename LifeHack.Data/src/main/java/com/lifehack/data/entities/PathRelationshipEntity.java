package com.lifehack.data.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference
@RelationshipEntity("Path")
public class PathRelationshipEntity {
    @Id
    @GeneratedValue
    public Long id;
    @StartNode
    public GoalNodeEntity previous;
    @EndNode
    public GoalNodeEntity next;
}
