package com.IGallinari.LastGame.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class TagPlayer {

    @EmbeddedId
    private idTagPlayer idTagPlayer;


    @ManyToOne
    @JoinColumn(name = "idBlog", insertable = false, updatable = false)
    private int idBlog;

    @ManyToOne
    @JoinColumn(name = "idPlayer", insertable = false, updatable = false)
    private int idPlayer;
}
