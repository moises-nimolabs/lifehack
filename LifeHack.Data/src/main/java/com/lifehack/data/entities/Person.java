package com.lifehack.data.entities;

import org.neo4j.ogm.annotation.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

@NodeEntity("Person")
public class Person {
    @Id
    @GeneratedValue
    @XmlElement
    public Long id;
    @Property
    public String name;
    @Relationship(type = "ChosenBy", direction = Relationship.INCOMING)
    public Set<Goal> goals;
}
