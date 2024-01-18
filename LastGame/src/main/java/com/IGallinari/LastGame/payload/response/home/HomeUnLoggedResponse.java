package com.IGallinari.LastGame.payload.response.home;

import com.IGallinari.LastGame.payload.response.home.blog.ViewBlogHome;
import com.IGallinari.LastGame.payload.response.home.nextGame.ViewNextGame;
import com.IGallinari.LastGame.payload.response.home.pastGame.ViewPastGame;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HomeUnLoggedResponse {
    private boolean logged;
    private List<ViewPastGame> pastGames;
    private List<ViewNextGame> nextGames;
    private List<ViewBlogHome> blogs;
}
