package com.lifehack.data.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

import javax.xml.bind.annotation.XmlElement;

public class Entity <T> {
    @Id @GeneratedValue @XmlElement
    public Long id;
}
