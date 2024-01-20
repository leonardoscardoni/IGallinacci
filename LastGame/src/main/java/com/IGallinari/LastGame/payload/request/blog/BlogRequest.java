package com.IGallinari.LastGame.payload.request.blog;

import com.IGallinari.LastGame.payload.request.blog.paragraph.ViewParagraph;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class BlogRequest {
    private String token;
    private String title;
    private String subTitle;
    private String img;
    private LocalDate date;
    private List<ViewParagraph> paragraphs;
    private int[] tagPlayer;
    private int[] tagTeam;
}
