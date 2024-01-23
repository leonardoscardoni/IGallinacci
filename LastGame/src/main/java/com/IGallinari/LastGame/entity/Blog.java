package com.IGallinari.LastGame.entity;

import lombok.Data;

import java.time.LocalDate;

import jakarta.persistence.*;

/**
 * Represents a blog post.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Entity
@Data
public class Blog {

    /**
     * The unique identifier for the blog post.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The User who authored the blog post.
     */
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    /**
     * The title of the blog post.
     */
    private String title;

    /**
     * A subtitle or brief description of the blog post.
     */
    private String subtitle;

    /**
     * The date on which the blog post was published or created.
     */
    private LocalDate date;

    /**
     * The image associated with the blog post.
     */
    private String img;

}
