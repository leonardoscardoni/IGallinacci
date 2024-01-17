package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdParagraph;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Paragraph {
    
    @EmbeddedId
    private IdParagraph idParagraph;
    
    @ManyToOne
    @JoinColumn(name="idBlog", insertable = false, updatable=false)
    private Blog blog;

    @Column(name="index", insertable = false, updatable=false)
    private int index;
    
    private String title;

    private String content;
}
