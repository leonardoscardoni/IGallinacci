package com.IGallinari.LastGame.entity.id_class;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

/**
 * Represents the composite primary key for the PlayerTeam entity.
 * This class is annotated with {@code @Embeddable} to indicate that it is embeddable in other entities.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Data
@Embeddable
public class IdPlayerTeam implements Serializable {

    /**
     * The team identifier associated with the player-team relationship.
     */
    @Column(name = "idTeam")
    private int teamId;

    /**
     * The player identifier associated with the player-team relationship.
     */
    @Column(name = "idPlayer")
    private int playerId;

    /**
     * The season identifier associated with the player-team relationship.
     */
    @Column(name = "season")
    private int season;
}
