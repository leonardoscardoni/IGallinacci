package com.IGallinari.LastGame.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class idTagTeam implements Serializable{
    
    @Column(name = "idBlog")
    private int idblog;

    @Column(name = "idTeam")
    private int idTeam;
}
