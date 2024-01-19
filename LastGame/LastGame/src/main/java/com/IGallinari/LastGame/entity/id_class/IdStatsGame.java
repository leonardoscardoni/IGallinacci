package com.IGallinari.LastGame.entity.id_class;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class IdStatsGame implements Serializable {

        @Column(name = "idTeam")
        private int teamId;

        @Column(name = "idGame")
        private int gameId;
}

