package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdTagPlayer;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents the association between a player and a blog post through tagging.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Entity
@Data
public class TagPlayer {

    /**
     * The composite primary key for the tagging association.
     */
    @EmbeddedId
    private IdTagPlayer idTagPlayer;

    /**
     * The Blog post associated with the player tag.
     */
    @ManyToOne
    @JoinColumn(name = "idBlog", insertable = false, updatable = false)
    private Blog blog;

    /**
     * The Player associated with the blog post tag.
     */
    @ManyToOne
    @JoinColumn(name = "idPlayer", insertable = false, updatable = false)
    private Player player;
}
