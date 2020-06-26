package com.lifehack.data.entities;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
public class Goal extends Entity {
    public Integer sequence;
    public String name;
    @Relationship(type = "Path")
    public Set<Goal> goals;
}
