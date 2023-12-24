package com.IGallinari.LastGame.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PlayerTeam {
    @EmbeddedId
    private IdPlayerTeam idPlayerTeam;

    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "idPlayer", insertable = false, updatable = false)
    private Player player;
}
