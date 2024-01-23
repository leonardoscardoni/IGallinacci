package com.IGallinari.LastGame.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Represents an NBA team.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Entity
@Data
public class Team {

    /**
     * The unique identifier for the team.
     */
    @Id
    private int id;

    /**
     * The name of the team.
     */
    private String name;

    /**
     * The nickname or commonly used name for the team.
     */
    private String nickname;

    /**
     * A code or abbreviation associated with the team.
     */
    private String code;

    /**
     * The city where the team is based.
     */
    private String city;

    /**
     * The logo representing the team.
     */
    private String logo;

    /**
     * Indicates whether the team is an all-star team.
     */
    private boolean allstar;

    /**
     * The conference to which the team belongs.
     */
    private String conference;

    /**
     * The division within the conference to which the team belongs.
     */
    private String division;
}

