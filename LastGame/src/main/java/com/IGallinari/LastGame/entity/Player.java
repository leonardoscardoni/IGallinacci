package com.IGallinari.LastGame.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

/**
 * Represents an NBA player.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Entity
@Data
public class Player {

    /**
     * The unique identifier for the player.
     */
    @Id
    private int id;

    /**
     * The first name of the player.
     */
    private String firstname;

    /**
     * The last name of the player.
     */
    private String lastname;

    /**
     * The date of birth of the player.
     */
    private LocalDate dateOfBirth;

    /**
     * The country of origin or nationality of the player.
     */
    private String country;

    /**
     * The year in which the player started their professional career.
     */
    private Integer startYear;

    /**
     * How many years he has been playing professionally.
     */
    private Integer pro;

    /**
     * The height (in meters) of the player.
     */
    private Float height;

    /**
     * The weight (in kilogram) of the player.
     */
    private Float weight;

    /**
     * The college or educational institution the player attended.
     */
    private String college;

    /**
     * The affiliation or team the player is associated with.
     */
    private String affiliation;

    /**
     * The jersey number worn by the player.
     */
    private Integer jersey;

    /**
     * Indicates whether the player is currently active.
     */
    private boolean isActive;

    /**
     * The playing position code of the player.
     */
    private String pos;

    /**
     * Gets the role description based on the NBA playing role code.
     *
     * @param nbaRole The NBA playing role code.
     * @return The corresponding role description.
     */
    public static String getRole(String nbaRole) {
        if (nbaRole == null) {
            return "";
        }
        switch (nbaRole) {
            case "C":
                return "Centro";
            case "C-F":
                return "Centro-Ala";
            case "F":
                return "Ala";
            case "F-C":
                return "Ala-Centro";
            case "F-G":
                return "Ala-Guardia";
            case "G":
                return "Guardia";
            case "G-F":
                return "Guardia-Ala";
            case "SF":
                return "Ala Piccola";
            case "SG":
                return "Guardia Tiratrice";
            case "PF":
                return "Ala Grande";
            case "PG":
                return "Playmaker";
            default:
                return "";
        }
    }
}
