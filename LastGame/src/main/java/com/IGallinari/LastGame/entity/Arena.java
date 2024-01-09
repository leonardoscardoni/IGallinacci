package com.IGallinari.LastGame.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Arena {

    @Id
    @Column(name = "name")
    private String name;

    private String city;

    private String state;

    private String country;
}
