package com.IGallinari.LastGame.entity.id_class;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class IdFavPlayer implements Serializable{
    
    @Column(name = "idUser")
    private int teamId;

    @Column(name = "idPlayer")
    private int playerId;

}