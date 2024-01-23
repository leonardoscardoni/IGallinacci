package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdStatsTeam;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents statistical data for a team.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Data
@Entity
public class StatsTeam {

    /**
     * The composite primary key for the team statistical data.
     */
    @EmbeddedId
    private IdStatsTeam statsTeamId;

    /**
     * The total number of games played by the team.
     */
    private Integer games;

    /**
     * Points scored in fast breaks by the team.
     */
    private Integer fastBreakPoints;

    /**
     * Points scored in the paint area by the team.
     */
    private Integer pointsInPaint;

    /**
     * The biggest lead achieved by the team in a game.
     */
    private Integer biggestLead;

    /**
     * Points scored from second chance opportunities by the team.
     */
    private Integer secondChancePoints;

    /**
     * Points scored off turnovers by the team.
     */
    private Integer pointsOffTurnovers;

    /**
     * The length of the longest run of consecutive points scored by the team.
     */
    private Integer longestRun;

    /**
     * Total points scored by the team.
     */
    private Integer points;

    /**
     * Field goals made by the team.
     */
    private Integer fgm;

    /**
     * Field goals attempted by the team.
     */
    private Integer fga;

    /**
     * Field goal percentage of the team.
     */
    private Float fgp;

    /**
     * Free throws made by the team.
     */
    private Integer ftm;

    /**
     * Free throws attempted by the team.
     */
    private Integer fta;

    /**
     * Free throw percentage of the team.
     */
    private Float ftp;

    /**
     * Three-pointers made by the team.
     */
    private Integer tpm;

    /**
     * Three-pointers attempted by the team.
     */
    private Integer tpa;

    /**
     * Three-point percentage of the team.
     */
    private Float tpp;

    /**
     * Offensive rebounds by the team.
     */
    private Integer offReb;

    /**
     * Defensive rebounds by the team.
     */
    private Integer defReb;

    /**
     * Total rebounds by the team.
     */
    private Integer totReb;

    /**
     * Assists by the team.
     */
    private Integer assists;

    /**
     * Personal fouls committed by the team.
     */
    private Integer pFouls;

    /**
     * Steals by the team.
     */
    private Integer steals;

    /**
     * Turnovers by the team.
     */
    private Integer turnovers;

    /**
     * Blocks by the team.
     */
    private Integer blocks;

    /**
     * Plus-minus statistic for the team.
     */
    private Integer plusMinus;

    /**
     * Conference ranking of the team.
     */
    private Integer rankConference;

    /**
     * Wins in the conference by the team.
     */
    private Integer winConference;

    /**
     * Losses in the conference by the team.
     */
    private Integer lossConference;

    /**
     * Division ranking of the team.
     */
    private Integer rankDivision;

    /**
     * Wins in the division by the team.
     */
    private Integer winDivision;

    /**
     * Losses in the division by the team.
     */
    private Integer lossDivision;

    /**
     * Wins at home by the team.
     */
    private Integer winHome;

    /**
     * Wins away from home by the team.
     */
    private Integer winAway;

    /**
     * Winning percentage of the team.
     */
    private Float winPerc;

    /**
     * Losses at home by the team.
     */
    private Integer lossHome;

    /**
     * Losses away from home by the team.
     */
    private Integer lossAway;

    /**
     * Losing percentage of the team.
     */
    private Float lossPerc;

    /**
     * Games behind in the standings for the team.
     */
    private Integer gamesBehind;

    /**
     * The current streak of the team.
     */
    private Integer streak;

    /**
     * Indicates whether the team is currently on a winning streak.
     */
    private boolean winStreak;

    /**
     * The Team associated with the statistical data.
     */
    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    /**
     * The season for which the statistical data is recorded.
     */
    @Column(name = "season", insertable = false, updatable = false)
    private int season;

}
