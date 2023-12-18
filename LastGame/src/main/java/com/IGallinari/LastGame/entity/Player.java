package com.IGallinari.LastGame.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Player {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;

    private String country;

    private Integer startYear;

    private Integer pro;

    private float heigth;

    private float weight;

    private String college;

    private String affiliation;

    private Integer jersey;

    private boolean isActive;

    private String pos;

}
