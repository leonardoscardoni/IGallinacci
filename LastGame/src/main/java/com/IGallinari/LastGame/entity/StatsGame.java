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

    private int win;
    private int lose;
    private int seriesWin;
    private int seriesLose;
    private String pointsPeriod;
    private int fastBreakPoint;
    private int pointsInPaint;
    private int biggestLead;
    private int secondChancePoints;
    private int pointsOffTurnovers;
    private int longestRun;
    private int points;
    private int fgm;
    private int fga;
    private Float fgp;
    private int ftm;
    private int fta;
    private Float ftp;
    private int tpm;
    private int tpa;
    private Float tpp;
    private int offReb;
    private int defReb;
    private int totReb;
    private int assists;
    private int pFouls;
    private int steals;
    private int turnovers;
    private int blocks;
    private int plusMinus;
    private String min;

    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "idGame", insertable = false, updatable = false)
    private Game game;

    // Altri campi e metodi, se necessario
}
