package com.IGallinari.LastGame.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Blog {
    @Id
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private int idUser;

    private String title;

    private String subtitle;

    private String content; // ...

    private String img;

}
