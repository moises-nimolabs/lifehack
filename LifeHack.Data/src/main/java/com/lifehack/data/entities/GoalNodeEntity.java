package com.lifehack.data.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.*;

import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference
@NodeEntity("Goal")
public class GoalNodeEntity {
    @JsonIdentityReference
    @Id @GeneratedValue
    public Long id;
    @Property("sequence")
    public Integer sequence;
    @Property("name")
    public String name;
    @Relationship(type = "Path", direction = Relationship.INCOMING)
    public Set<PathRelationshipEntity> previousPaths;
    @Relationship(type = "Path")
    public Set<PathRelationshipEntity> nextPaths;
}
