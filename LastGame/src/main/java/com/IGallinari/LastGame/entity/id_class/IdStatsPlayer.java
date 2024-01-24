package com.IGallinari.LastGame.entity.id_class;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

/**
 * Represents the composite primary key for the StatsPlayer entity.
 * This class is annotated with {@code @Embeddable} to indicate that it is embeddable in other entities.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Data
@Embeddable
public class IdStatsPlayer implements Serializable {

    /**
     * The player identifier associated with the statistical data.
     */
    @Column(name = "idPlayer")
    private int playerId;

    /**
     * The team identifier associated with the statistical data in a game.
     */
    @Column(name = "idTeam")
    private int teamId;

    /**
     * The game identifier associated with the statistical data.
     */
    @Column(name = "idGame")
    private int gameId;
}
