package com.IGallinari.LastGame.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Player {

    @Id
    @Column(name = "idPlayer")
    private int id;

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;

    private String country;

    private int startYear;

    private int pro;

    private float heigth;

    private float weight;

    private String college;

    private String affiliation;

    private int jersey;

    private boolean isActive;

    private String pos;
}
