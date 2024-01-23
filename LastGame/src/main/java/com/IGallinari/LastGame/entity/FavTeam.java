package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdFavTeam;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents a user's favorite sports team.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Entity
@Data
public class FavTeam {

    /**
     * The composite primary key for the favorite team association.
     */
    @EmbeddedId
    private IdFavTeam idFavTeam;

    /**
     * The User who has the team as a favorite.
     */
    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User user;

    /**
     * The Team that is marked as a favorite by the user.
     */
    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;
}
