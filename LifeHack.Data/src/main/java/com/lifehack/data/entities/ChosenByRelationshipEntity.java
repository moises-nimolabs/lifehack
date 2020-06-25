package com.lifehack.data.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference
@RelationshipEntity("ChosenBy")
public class ChosenByRelationshipEntity {
    @Id @GeneratedValue
    public Long id;
    @StartNode
    public GoalNodeEntity goal;
    @EndNode
    public PersonNodeEntity person;
}
