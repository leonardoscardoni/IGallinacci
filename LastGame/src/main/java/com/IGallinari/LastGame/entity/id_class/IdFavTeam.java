package com.IGallinari.LastGame.entity.id_class;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
public class IdFavTeam implements Serializable{

    @Column(name = "idUser")
    private int idUser;

    @Column(name = "idTeam")
    private int idTeam;

}
