package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdTagTeam;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents the association between a team and a blog post through tagging.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Entity
@Data
public class TagTeam {

    /**
     * The composite primary key for the tagging association.
     */
    @EmbeddedId
    private IdTagTeam idTagTeam;

    /**
     * The Blog post associated with the team tag.
     */
    @ManyToOne
    @JoinColumn(name = "idBlog", insertable = false, updatable = false)
    private Blog blog;

    /**
     * The Team associated with the blog post tag.
     */
    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;
}
