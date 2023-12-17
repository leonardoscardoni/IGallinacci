package com.IGallinari.LastGame.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

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

    private LocalDate gameDate;

    private LocalTime startTime;

    private Integer stage;

    private Integer totPeriods;

    @ManyToOne
    @JoinColumn(name = "nameArena")
    private Arena arena;

    @ManyToOne
    @JoinColumn(name = "idTeam")
    private Team visitorTeam;

    @ManyToOne
    @JoinColumn(name = "id_home")
    private Team homeTeam;
}
