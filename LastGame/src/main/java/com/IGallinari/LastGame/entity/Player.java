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

    public static String getRole(String nbaRole) {
        if (nbaRole == null) {
            return "";
        }
        switch(nbaRole) {
            case "C":
                return "Centro";
            case "C-F":
                return "Centro-Ala Grande";
            case "F":
                return "Ala Grande";
            case "F-C":
                return "Ala Grande-Centro";
            case "F-G":
                return "Ala Grande-Guardia";
            case "G":
                return "Guardia";
            case "G-F":
                return "Guardia-Ala Grande";
            case "SF":
                return "Ala Piccola";
            case "SG":
                return "Guardia Tiratrice";
            default:
                return "";
        }
    }


}
