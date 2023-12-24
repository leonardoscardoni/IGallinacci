package com.IGallinari.LastGame.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Player {

    @Id
    private int id;

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;

    private String country;

    private Integer startYear;

    private Integer pro;

    private Float height;

    private Float weight;

    private String college;

    private String affiliation;

    private Integer jersey;

    private boolean isActive;

    private String pos;

}
