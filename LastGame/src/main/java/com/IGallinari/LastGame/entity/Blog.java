package com.IGallinari.LastGame.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    private String title;

    private String subtitle;

    private String content; // ...

    private String img;

}
