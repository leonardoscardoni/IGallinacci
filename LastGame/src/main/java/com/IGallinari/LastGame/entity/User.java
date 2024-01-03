package com.IGallinari.LastGame.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    private int id;

    private String email;

    private String password;
    
    private String name;

    private String role;
}
