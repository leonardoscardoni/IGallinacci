package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdFavPlayer;
import lombok.Data;
import jakarta.persistence.*;

/**
 * Represents a user's favorite player.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Entity
@Data
public class FavPlayer {

    /**
     * The composite primary key for the favorite player association.
     */
    @EmbeddedId
    private IdFavPlayer idFavPlayer;

    /**
     * The User who has the player as a favorite.
     */
    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User user;

    /**
     * The Player who is marked as a favorite by the user.
     */
    @ManyToOne
    @JoinColumn(name = "idPlayer", insertable = false, updatable = false)
    private Player player;
}
