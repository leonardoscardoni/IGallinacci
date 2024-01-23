package com.IGallinari.LastGame.entity.id_class;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

/**
 * Represents the composite primary key for the StatsTeam entity.
 * This class is annotated with {@code @Embeddable} to indicate that it is embeddable in other entities.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Data
@Embeddable
public class IdStatsTeam implements Serializable {

    /**
     * The team identifier associated with the statistical data.
     */
    @Column(name = "idTeam")
    private int teamId;

    /**
     * The season identifier associated with the statistical data.
     */
    @Column(name = "season")
    private int season;
}
