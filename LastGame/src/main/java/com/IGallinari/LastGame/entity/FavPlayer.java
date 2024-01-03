package com.IGallinari.LastGame.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class FavPlayer {
    
    @EmbeddedId
    private IdFavPlayer idFavPlayer;

    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private int idUser;

    @ManyToOne
    @JoinColumn(name = "idPlayer", insertable = false, updatable = false)
    private int idPlayer;
}
