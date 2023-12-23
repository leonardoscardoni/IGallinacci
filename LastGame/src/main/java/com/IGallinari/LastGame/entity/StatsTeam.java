package com.IGallinari.LastGame.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class StatsTeam {

    @EmbeddedId
    private IdStatsTeam statsTeamId;

    private Integer games;

    private Integer fastBreakPoints;

    private Integer pointsInPaint;

    private Integer biggestLead;

    private Integer secondChancePoints;

    private Integer pointsOffTurnovers;

    private Integer longestRun;

    private Integer points;

    private Integer fgm;

    private Integer fga;

    private Float fgp;

    private Integer ftm;

    private Integer fta;

    private Float ftp;

    private Integer tpm;

    private Integer tpa;

    private Float tpp;

    private Integer offReb;

    private Integer defReb;

    private Integer totReb;

    private Integer assists;

    private Integer pFouls;

    private Integer steals;

    private Integer turnovers;

    private Integer blocks;

    private Integer plusMinus;

    private Integer rankConference;

    private Integer winConference;

    private Integer lossConference;

    private Integer rankDivision;

    private Integer winDivision;

    private Integer lossDivision;

    private Integer winHome;

    private Integer winAway;

    private float winPerc;

    private Integer lossHome;

    private Integer lossAway;

    private float lossPerc;

    private Integer gamesBehind;

    private Integer streak;

    private boolean winStreak;

    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    @Column(name = "season", insertable = false, updatable = false)
    private int season;

}
