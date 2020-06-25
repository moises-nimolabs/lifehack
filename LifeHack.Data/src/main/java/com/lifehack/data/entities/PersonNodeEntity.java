package com.lifehack.data.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.*;

import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference
@NodeEntity("Person")
public class PersonNodeEntity {
    @Id @GeneratedValue
    private Long id;
    @Property("name")
    private String name;
    @Relationship(type = "ChosenBy", direction = Relationship.INCOMING)
    private Set<ChosenByRelationshipEntity> choices;
}
