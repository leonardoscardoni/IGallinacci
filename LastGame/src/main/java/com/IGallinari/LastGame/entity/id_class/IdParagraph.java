package com.IGallinari.LastGame.entity.id_class;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class IdParagraph implements Serializable {

    @Column(name = "idBlog")
    private int idBlog;

    @Column(name = "number")
    private int number;
}
