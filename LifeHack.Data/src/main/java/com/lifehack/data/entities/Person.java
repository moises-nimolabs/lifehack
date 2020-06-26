package com.lifehack.data.entities;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class Person extends Entity {
    @Property
    public String name;
}
