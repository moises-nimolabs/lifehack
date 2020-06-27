package com.lifehack.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = {"com.lifehack.data.repositories"})
@EntityScan(basePackages = {"com.lifehack.data.entities"})
public class LifehackdataApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(LifehackdataApplication.class, args);
    }
}
