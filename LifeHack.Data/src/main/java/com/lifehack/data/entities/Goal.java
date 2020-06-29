package com.lifehack.data.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;
import java.util.Set;

@NodeEntity("Goal")
public class Goal  {
    @Id
    @GeneratedValue
    @XmlElement
    public Long id;
    public Integer sequence;
    public String name;
    @Relationship(type = "Path")
    public Set<Goal> goals;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal entity = (Goal) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
