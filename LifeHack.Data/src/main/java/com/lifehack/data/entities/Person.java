package com.lifehack.data.entities;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
public class Person extends Entity {
    @Property
    public String name;
    @Relationship(type = "ChosenBy", direction = Relationship.INCOMING)
    public Set<Goal> goals;
}
