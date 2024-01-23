package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdPlayerTeam;
import jakarta.persistence.Entity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import lombok.Data;

/**
 * Represents the association between a player and a team for a specific season.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Entity
@Data
public class PlayerTeam {

    /**
     * The composite primary key for the player-team association.
     */
    @EmbeddedId
    private IdPlayerTeam idPlayerTeam;

    /**
     * The Team associated with the player.
     */
    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    /**
     * The Player associated with the team.
     */
    @ManyToOne
    @JoinColumn(name = "idPlayer", insertable = false, updatable = false)
    private Player player;

    /**
     * The season for which the player is associated with the team.
     */
    @Column(name = "season", insertable = false, updatable = false)
    private int season;
}
