package com.IGallinari.LastGame.payload.response.blog;

import com.IGallinari.LastGame.payload.response.blog.paragraph.ViewParagraphResponse;
import com.IGallinari.LastGame.payload.response.blog.paragraph.tagPlayer.ViewTagPlayer;
import com.IGallinari.LastGame.payload.response.blog.paragraph.tagTeam.ViewTagTeam;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class BlogResponse {
    private boolean logged;
    private String emailAuthor;
    private String title;
    private String subTitle;
    private String img;
    private LocalDate date;
    private List<ViewParagraphResponse> paragraphs;
    private List<ViewTagPlayer> tagPlayer;
    private List<ViewTagTeam> tagTeam;
}
