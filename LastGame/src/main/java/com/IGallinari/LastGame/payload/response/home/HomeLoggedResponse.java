package com.IGallinari.LastGame.payload.response.home;

import com.IGallinari.LastGame.payload.response.home.blog.ViewBlogHome;
import com.IGallinari.LastGame.payload.response.home.nextGame.ViewNextGame;
import com.IGallinari.LastGame.payload.response.home.pastGame.ViewPastGame;
import com.IGallinari.LastGame.payload.response.home.standigs.ViewTeamStandingHome;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HomeLoggedResponse {
    private boolean logged;
    private List<ViewPastGame> pastGames;
    private List<ViewPastGame> favTeamsPastGame;
    private List<ViewNextGame> nextGames;
    private List<ViewNextGame> favTeamsNextGame;
    private List<ViewTeamStandingHome> eastStandings;
    private List<ViewTeamStandingHome> westStandings;
    private List<ViewBlogHome> blogs;
}
