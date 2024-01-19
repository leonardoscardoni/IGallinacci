package com.IGallinari.LastGame.entity.id_class;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class IdStatsPlayer implements Serializable {

    @Column(name = "idPlayer")
    private int playerId;

    @Column(name = "idTeam")
    private int teamId;

    @Column(name = "idGame")
    private int gameId;
}
