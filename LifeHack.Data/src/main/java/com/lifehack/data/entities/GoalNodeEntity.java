package com.lifehack.data.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity("Goal")
public class GoalNodeEntity {
    @Id @GeneratedValue
    private Long id;
    @Property("sequence")
    private Integer sequence;
    @Property("name")
    private String name;
}
