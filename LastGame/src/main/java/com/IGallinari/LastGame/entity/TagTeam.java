package com.IGallinari.LastGame.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TagTeam {

    @EmbeddedId
    private com.IGallinari.LastGame.entity.id_class.idTagTeam idTagTeam;

    @ManyToOne
    @JoinColumn(name = "idBlog", insertable = false, updatable = false)
    private Blog blog;


    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;
    
}
