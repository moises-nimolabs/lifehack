package com.lifehack.data.entities;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity("ChosenBy")
public class ChosenByRelationshipEntity {
    @Id @GeneratedValue
    private Long id;
    @StartNode
    private GoalNodeEntity goal;
    @EndNode
    private PersonNodeEntity person;
}
