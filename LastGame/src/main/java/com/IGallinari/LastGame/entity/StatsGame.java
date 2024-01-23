package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdStatsGame;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Represents statistical data for a game.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Data
@Entity
public class StatsGame {

    /**
     * The composite primary key for the statistical data.
     */
    @EmbeddedId
    private IdStatsGame statsGameId;

    /**
     * The number of games won.
     */
    private Integer win;

    /**
     * The number of games lost.
     */
    private Integer lose;

    /**
     * The number of series won.
     */
    private Integer seriesWin;

    /**
     * The number of series lost.
     */
    private Integer seriesLose;

    /**
     * Points scored in each period of the game.
     */
    private String pointsPeriod;

    /**
     * Points scored in fast breaks.
     */
    private Integer fastBreakPoint;

    /**
     * Points scored in the paint area.
     */
    private Integer pointsInPaint;

    /**
     * The biggest lead in the game.
     */
    private Integer biggestLead;

    /**
     * Points scored from second chance opportunities.
     */
    private Integer secondChancePoints;

    /**
     * Points scored off turnovers.
     */
    private Integer pointsOffTurnovers;

    /**
     * The longest run of consecutive points scored.
     */
    private Integer longestRun;

    /**
     * Total points scored in the game.
     */
    private Integer points;

    /**
     * Field goals made.
     */
    private Integer fgm;

    /**
     * Field goals attempted.
     */
    private Integer fga;

    /**
     * Field goal percentage.
     */
    private Float fgp;

    /**
     * Free throws made.
     */
    private Integer ftm;

    /**
     * Free throws attempted.
     */
    private Integer fta;

    /**
     * Free throw percentage.
     */
    private Float ftp;

    /**
     * Three-pointers made.
     */
    private Integer tpm;

    /**
     * Three-pointers attempted.
     */
    private Integer tpa;

    /**
     * Three-point percentage.
     */
    private Float tpp;

    /**
     * Offensive rebounds.
     */
    private Integer offReb;

    /**
     * Defensive rebounds.
     */
    private Integer defReb;

    /**
     * Total rebounds.
     */
    private Integer totReb;

    /**
     * Assists.
     */
    private Integer assists;

    /**
     * Personal fouls committed.
     */
    private Integer pFouls;

    /**
     * Steals.
     */
    private Integer steals;

    /**
     * Turnovers.
     */
    private Integer turnovers;

    /**
     * Blocks.
     */
    private Integer blocks;

    /**
     * Plus-minus statistic.
     */
    private Integer plusMinus;

    /**
     * Total minutes played.
     */
    private String min;

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
