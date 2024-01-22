package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdTagPlayer;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class TagPlayer {

    @EmbeddedId
    private IdTagPlayer idTagPlayer;


    @ManyToOne
    @JoinColumn(name = "idBlog", insertable = false, updatable = false)
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "idPlayer", insertable = false, updatable = false)
    private Player player;
}
