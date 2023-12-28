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

    private Integer season;

    private LocalDate date;

    private LocalTime time;

    private Integer stage;

    private Integer totperiods;

    @ManyToOne
    @JoinColumn(name = "nameArena")
    private Arena arena;

    @ManyToOne
    @JoinColumn(name = "idVisitor")
    private Team visitorTeam;

    @ManyToOne
    @JoinColumn(name = "idHome")
    private Team homeTeam;
}
