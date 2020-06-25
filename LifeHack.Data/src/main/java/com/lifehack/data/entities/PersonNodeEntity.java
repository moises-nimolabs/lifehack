package com.lifehack.data.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity("Person")
public class PersonNodeEntity {
    @Id @GeneratedValue
    private Long id;
    @Property("name")
    private String name;
}
