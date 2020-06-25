package com.lifehack.data.entities;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity("Result")
public class LifeResultRelationShipEntity {
    @Id @GeneratedValue
    private Long id;
    @StartNode
    private PersonNodeEntity person;
    @EndNode
    private GoalNodeEntity goal;
}
