package com.IGallinari.LastGame.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Team {

    @Id
    private int id;

    private String name;
    private String nickname;
    private String code;
    private String city;
    private String logo;
    private boolean allstar;
    private String conference;
    private String division;
}
