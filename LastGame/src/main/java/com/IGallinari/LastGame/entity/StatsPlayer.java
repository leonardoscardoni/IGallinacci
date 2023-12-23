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

    private Integer points;

    private String pos;

    private Integer min;

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

    @ManyToOne
    @JoinColumn(name = "idPlayer")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "idTeam")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "idGame")
    private Game game;
}
