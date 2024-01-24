package com.IGallinari.LastGame.entity.id_class;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

/**
 * Represents the composite primary key for the FavTeam entity.
 * This class is annotated with {@code @Embeddable} to indicate that it is embeddable in other entities.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Data
@Embeddable
public class IdFavTeam implements Serializable {

    /**
     * The user identifier.
     */
    @Column(name = "idUser")
    private int idUser;

    /**
     * The team identifier.
     */
    @Column(name = "idTeam")
    private int idTeam;

}
