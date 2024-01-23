package com.IGallinari.LastGame.entity;


import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents an NBA game.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Entity
@Data
public class Game {

    /**
     * The unique identifier for the game.
     */
    @Id
    private int id;

    /**
     * The season in which the game takes place.
     */
    private Integer season;

    /**
     * The date on which the game is scheduled or played.
     */
    private LocalDate date;

    /**
     * The time at which the game is scheduled or played.
     */
    private LocalTime time;

    /**
     * The stage of the game.
     */
    private Integer stage;

    /**
     * The total number of periods in the game.
     */
    private Integer totperiods;

    /**
     * The status of the game (1=not started, 2=live, 3=finished).
     */
    private Integer status;

    /**
     * The Arena where the game is scheduled or played.
     */
    @ManyToOne
    @JoinColumn(name = "nameArena")
    private Arena arena;

    /**
     * The visiting Team participating in the game.
     */
    @ManyToOne
    @JoinColumn(name = "idVisitor")
    private Team visitorTeam;

    /**
     * The home Team participating in the game.
     */
    @ManyToOne
    @JoinColumn(name = "idHome")
    private Team homeTeam;
}

