package com.IGallinari.LastGame.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TagTeam {

    @EmbeddedId
    private idTagTeam idTagTeam;

    @ManyToOne
    @JoinColumn(name = "idBlog", insertable = false, updatable = false)
    private int idBlog;


    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private int idTeam;
    
}
