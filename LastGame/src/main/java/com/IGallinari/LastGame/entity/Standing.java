package com.IGallinari.LastGame.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Standing {

    @EmbeddedId
    private IdStanding standingId;

    private int rankConference;
    private int winConference;
    private int lossConference;
    private int rankDivision;
    private int winDivision;
    private int lossDivision;
    private int winHome;
    private int winAway;
    private float winPerc;
    private int lossHome;
    private int lossAway;
    private float lossPerc;
    private int gamesBehind;
    private int streak;
    private boolean winStreak;

    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    @JoinColumn(name = "season")
    private int season;
}
