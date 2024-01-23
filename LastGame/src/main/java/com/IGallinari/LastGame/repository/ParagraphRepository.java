package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Blog;
import com.IGallinari.LastGame.entity.Paragraph;
import com.IGallinari.LastGame.entity.id_class.IdParagraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface represents the repository for managing Paragraph entities.
 * It extends the JpaRepository interface provided by Spring Data JPA.
 *
 */
@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, IdParagraph> {

    /**
     * Retrieves a list of Paragraphs objects for a specified blog, ordered by paragraph number.
     *
     * @param blog The blog for which to retrieve paragraphs.
     * @return List of Paragraphs objects for the specified blog, ordered by paragraph number.
     */
    List<Paragraph> findParagraphByBlogOrderByNumber(Blog blog);

}
