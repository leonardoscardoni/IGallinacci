package com.IGallinari.LastGame.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Represents an arena where game take place.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Entity
@Data
public class Arena {

    /**
     * The unique identifier for the arena, mapped to the "name" column in the database.
     */
    @Id
    @Column(name = "name")
    private String name;

    /**
     * The city where the arena is located.
     */
    private String city;

    /**
     * The state or region where the arena is situated.
     */
    private String state;

    /**
     * The country where the arena is located.
     */
    private String country;
}

