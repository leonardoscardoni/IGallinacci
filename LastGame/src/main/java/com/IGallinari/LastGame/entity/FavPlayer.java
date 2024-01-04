package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdFavPlayer;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class FavPlayer {
    
    @EmbeddedId
    private IdFavPlayer idFavPlayer;

    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idPlayer", insertable = false, updatable = false)
    private Player player;
}
