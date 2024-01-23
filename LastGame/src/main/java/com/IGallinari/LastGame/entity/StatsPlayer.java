package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdStatsPlayer;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Represents statistical data for a player in a game.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Data
@Entity
public class StatsPlayer {

    /**
     * The composite primary key for the player statistical data.
     */
    @EmbeddedId
    private IdStatsPlayer statsPlayerId;

    /**
     * Total points scored by the player.
     */
    private Integer points;

    /**
     * The playing position of the player.
     */
    private String pos;

    /**
     * Total minutes played by the player.
     */
    private Integer min;

    /**
     * Field goals made by the player.
     */
    private Integer fgm;

    /**
     * Field goals attempted by the player.
     */
    private Integer fga;

    /**
     * Field goal percentage of the player.
     */
    private Float fgp;

    /**
     * Free throws made by the player.
     */
    private Integer ftm;

    /**
     * Free throws attempted by the player.
     */
    private Integer fta;

    /**
     * Free throw percentage of the player.
     */
    private Float ftp;

    /**
     * Three-pointers made by the player.
     */
    private Integer tpm;

    /**
     * Three-pointers attempted by the player.
     */
    private Integer tpa;

    /**
     * Three-point percentage of the player.
     */
    private Float tpp;

    /**
     * Offensive rebounds by the player.
     */
    private Integer offReb;

    /**
     * Defensive rebounds by the player.
     */
    private Integer defReb;

    /**
     * Total rebounds by the player.
     */
    private Integer totReb;

    /**
     * Assists by the player.
     */
    private Integer assists;

    /**
     * Personal fouls committed by the player.
     */
    private Integer pFouls;

    /**
     * Steals by the player.
     */
    private Integer steals;

    /**
     * Turnovers by the player.
     */
    private Integer turnovers;

    /**
     * Blocks by the player.
     */
    private Integer blocks;

    /**
     * Plus-minus statistic for the player.
     */
    private Integer plusMinus;

    /**
     * The Player associated with the statistical data.
     */
    @ManyToOne
    @JoinColumn(name = "idPlayer", insertable = false, updatable = false)
    private Player player;

    /**
     * The Team associated with the statistical data.
     */
    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    /**
     * The Game associated with the statistical data.
     */
    @ManyToOne
    @JoinColumn(name = "idGame", insertable = false, updatable = false)
    private Game game;
}
