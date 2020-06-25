package com.lifehack.data.entities;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity("Path")
public class PathRelationshipEntity {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private GoalNodeEntity previous;
    @EndNode
    private GoalNodeEntity next;
}
