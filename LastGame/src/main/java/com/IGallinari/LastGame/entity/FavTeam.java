package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdFavTeam;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FavTeam {
    
    @EmbeddedId
    private IdFavTeam idFavPlayer;

    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;
}
