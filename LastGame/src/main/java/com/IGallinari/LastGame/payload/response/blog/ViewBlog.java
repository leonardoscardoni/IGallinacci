package com.IGallinari.LastGame.payload.response.blog;

import com.IGallinari.LastGame.payload.response.blog.paragraph.tagPlayer.ViewTagPlayer;
import com.IGallinari.LastGame.payload.response.blog.paragraph.tagTeam.ViewTagTeam;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class ViewBlog {
    private int idBlog;
    private String title;
    private String subtitle;
    private String img;
    private LocalDate date;
    private List<ViewTagPlayer> tagPlayer;
    private List<ViewTagTeam> tagTeam;
}
