package com.IGallinari.LastGame.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class StatsPlayer {

    @EmbeddedId
    private IdStatsPlayer statsPlayerId;

    private int points;
    private String pos;
    private Float min;
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
    @JoinColumn(name = "idPlayer", insertable = false, updatable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "idGame", insertable = false, updatable = false)
    private Game game;

    // Altri campi e metodi, se necessario
}
