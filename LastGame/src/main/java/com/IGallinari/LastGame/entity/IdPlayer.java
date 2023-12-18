package com.IGallinari.LastGame.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class IdPlayer implements Serializable {

    @Column(name = "idTeam")
    private int teamId;

    @Column(name = "id")
    private int id;
}
