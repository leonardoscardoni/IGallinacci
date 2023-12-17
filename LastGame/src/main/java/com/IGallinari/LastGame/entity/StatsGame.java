package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.IdStatsGame;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class StatsGame {

    @EmbeddedId
    private IdStatsGame statsGameId;

    private Integer win;

    private Integer lose;

    private Integer seriesWin;

    private Integer seriesLose;

    private String pointsPeriod;

    private Integer fastBreakPoint;

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

    private String min;

    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "idGame", insertable = false, updatable = false)
    private Game game;
}
