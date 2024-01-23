package com.IGallinari.LastGame.entity;

import com.IGallinari.LastGame.entity.id_class.IdParagraph;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents a paragraph within a blog post.
 * This entity is annotated with {@code @Entity} to indicate that it is a JPA entity
 * and can be persisted in a relational database.
 * The {@code @Data} annotation is used to generate boilerplate code for getters, setters, equals, hashCode, and toString.
 */
@Entity
@Data
public class Paragraph {

    /**
     * The composite primary key for the paragraph.
     */
    @EmbeddedId
    private IdParagraph idParagraph;

    /**
     * The blog to which the paragraph belongs.
     */
    @ManyToOne
    @JoinColumn(name = "idBlog", insertable = false, updatable = false)
    private Blog blog;

    /**
     * The sequence number of the paragraph within the blog post.
     */
    @Column(name = "number", insertable = false, updatable = false)
    private int number;

    /**
     * The title of the paragraph.
     */
    private String title;

    /**
     * The content of the paragraph.
     */
    private String content;
}
