package com.IGallinari.LastGame.repository;

import com.IGallinari.LastGame.entity.Blog;
import com.IGallinari.LastGame.entity.Paragraph;
import com.IGallinari.LastGame.entity.id_class.IdParagraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, IdParagraph> {

    List<Paragraph> findParagraphByBlogOrderByNumber(Blog blog);

}
