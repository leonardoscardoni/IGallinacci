package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.Arena;
import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.repository.ArenaRepository;
import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.StatsGameRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GamesHandler {

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    private TeamRepository teamRepository;
    private ArenaRepository arenaRepository;

    private GameRepository gameRepository;

    private StatsGameRepository statsGameRepository;

    public void handle(JsonNode jsonNode) {
        JsonNode gamesNode = jsonNode.get("response").get(0);

        for (JsonNode gameNode : gamesNode) {
            if(!arenaRepository.existsBynameArena(gameNode.get("arena").get("name").asText())) {
                Arena arena = new Arena();
                arena.setNameArena(gameNode.get("arena").get("name").asText());
                arena.setCity(gameNode.get("arena").get("city").asText());
                arena.setState(gameNode.get("arena").get("state").asText());
                arena.setCountry(gameNode.get("arena").get("country").asText());
                arenaRepository.save(arena);
            }

            String dateString = gameNode.get("date").get("start").asText();
            Game game = new Game();
            game.setId(gameNode.get("id").asInt());
            LocalDate gameDate = LocalDate.parse(dateString.substring(0, 10), dateFormatter);
            LocalTime startTime = LocalTime.parse(dateString.substring(11, 19), timeFormatter);
            startTime.plusHours(1);
            LocalTime midNight = LocalTime.of(00,00,00);
            int timeComparison = startTime.compareTo(midNight);
            if (timeComparison >= 0) {
                gameDate.plusDays(1);
            }
            game.setGameDate(gameDate);
            game.setStartTime(startTime);
            game.setStage(gameNode.get("stage").asInt());
            game.setTotPeriods(gameNode.get("periods").get("total").asInt());
            game.setArena(arenaRepository.findBynameArena(gameNode.get("arena").get("name").asText()));
            game.setVisitorTeam(teamRepository.findById(gameNode.get("teams").get("visitors").get("id").asInt()));
            game.setHomeTeam(teamRepository.findById(gameNode.get("teams").get("home").get("id").asInt()));
            gameRepository.save(game);

            StatsGame statsGameVisitor = new StatsGame();
            statsGameVisitor.setTeam(teamRepository.findById(gameNode.get("teams").get("visitors").get("id").asInt()));
            statsGameVisitor.setGame(gameRepository.findById(gameNode.get("id").asInt()));
            statsGameVisitor.setWin(gameNode.get("scores").get("visitors").get("win").asInt());
            statsGameVisitor.setLose(gameNode.get("scores").get("visitors").get("loss").asInt());
            statsGameVisitor.setSeriesWin(gameNode.get("scores").get("visitors").get("series").get("win").asInt());
            statsGameVisitor.setSeriesLose(gameNode.get("scores").get("visitors").get("series").get("loss").asInt());
            statsGameVisitor.setPointsPeriod(gameNode.get("scores").get("visitors").get("linescore").asText());
            statsGameVisitor.setPoints(gameNode.get("scores").get("visitors").get("points").asInt());
            statsGameRepository.save(statsGameVisitor);

            StatsGame statsGameHome = new StatsGame();
            statsGameHome.setTeam(teamRepository.findById(gameNode.get("teams").get("visitors").get("id").asInt()));
            statsGameHome.setGame(gameRepository.findById(gameNode.get("id").asInt()));
            statsGameHome.setWin(gameNode.get("scores").get("home").get("win").asInt());
            statsGameHome.setLose(gameNode.get("scores").get("home").get("loss").asInt());
            statsGameHome.setSeriesWin(gameNode.get("scores").get("home").get("series").get("win").asInt());
            statsGameHome.setSeriesLose(gameNode.get("scores").get("home").get("series").get("loss").asInt());
            statsGameHome.setPointsPeriod(gameNode.get("scores").get("home").get("linescore").asText());
            statsGameHome.setPoints(gameNode.get("scores").get("home").get("points").asInt());
            statsGameRepository.save(statsGameHome);
        }
    }
}

