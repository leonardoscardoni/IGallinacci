package com.IGallinari.LastGame.entity.id_class;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class idTagPlayer implements Serializable {
    
    @Column(name = "idBlog")
    private int idblog;

    @Column(name = "idPlayer")
    private int idPlayer;
}
