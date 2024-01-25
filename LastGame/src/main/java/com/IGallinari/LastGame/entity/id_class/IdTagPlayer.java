package com.IGallinari.LastGame.entity.id_class;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

/**
 * Represents the composite primary key for the TagPlayer entity.
 * This class is annotated with {@code @Embeddable} to indicate that it is embeddable in other entities.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Data
@Embeddable
public class IdTagPlayer implements Serializable {

    /**
     * The blog identifier associated with the player tag.
     */
    @Column(name = "idBlog")
    private int idBlog;

    /**
     * The player identifier associated with the blog post tag.
     */
    @Column(name = "idPlayer")
    private int idPlayer;
}
