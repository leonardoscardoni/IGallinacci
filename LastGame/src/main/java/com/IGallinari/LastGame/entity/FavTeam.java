package com.IGallinari.LastGame.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FavTeam {
    
    @EmbeddedId
    private IdFavTeam idFavPlayer;

    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private int idUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private int idTeam;
}
