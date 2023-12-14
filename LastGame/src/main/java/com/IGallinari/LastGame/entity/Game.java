package com.IGallinari.LastGame.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
public class Game {

    @Id
    private int id;

    private Date gameDate;

    private Time startTime;

    private int stage;

    private int totPeriods;

    @ManyToOne
    @JoinColumn(name = "nameArena")
    private Arena arena;

    @ManyToOne
    @JoinColumn(name = "idTeam")
    private Team visitorTeam;

    @ManyToOne
    @JoinColumn(name = "id_home")
    private Team homeTeam;

    // getters and setters
}
