package com.IGallinari.LastGame.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class StatsTeam {

    @EmbeddedId
    private IdStatsTeam statsTeamId;

    private int game;
    private int fastBreakPoints;
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

    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    @Column(name = "season", insertable = false, updatable = false)
    private int season;

}
