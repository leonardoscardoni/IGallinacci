package com.IGallinari.LastGame.entity.id_class;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

/**
 * Represents the composite primary key for the TagTeam entity.
 * This class is annotated with {@code @Embeddable} to indicate that it is embeddable in other entities.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Data
@Embeddable
public class IdTagTeam implements Serializable {

    /**
     * The blog identifier associated with the team tag.
     */
    @Column(name = "idBlog")
    private int idBlog;

    /**
     * The team identifier associated with the blog post tag.
     */
    @Column(name = "idTeam")
    private int idTeam;
}
