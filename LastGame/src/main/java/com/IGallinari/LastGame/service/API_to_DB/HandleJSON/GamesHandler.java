package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.IGallinari.LastGame.entity.Arena;
import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.repository.ArenaRepository;
import com.IGallinari.LastGame.repository.GameRepository;
import com.IGallinari.LastGame.repository.StatsGameRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class GamesHandler implements Handler {

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private TeamRepository teamRepository;

    private ArenaRepository arenaRepository;

    private GameRepository gameRepository;

    private StatsGameRepository statsGameRepository;

    @Override
    public void handle(JsonNode jsonNode) {
        JsonNode [] gamesNode = new JsonNode[]{jsonNode.get("response").get(0)};

        for (JsonNode gameNode : gamesNode) {
            if(!arenaRepository.existsBynameArena(gameNode.get("arena").get("name").asText())) {
                Arena arena = new Arena();
                arena.setNameArena(gameNode.get("arena").get("name").asText());
                arena.setCity(gameNode.get("arena").get("city").asText(null));
                arena.setState(gameNode.get("arena").get("state").asText(null));
                arena.setCountry(gameNode.get("arena").get("country").asText(null));
                arenaRepository.save(arena);
                System.out.println("Object Arena arena saved in the DB");
            }

            String dateString = gameNode.get("date").get("start").asText(null);
            LocalDate gameDate = null;
            LocalTime startTime = null;
            Game game = new Game();
            game.setId(gameNode.get("id").asInt());
            game.setSeason(asInteger(gameNode.get("season")));
            if(dateString!=null) {
                gameDate = LocalDate.parse(dateString.substring(0, 10), dateFormatter);
                startTime = LocalTime.parse(dateString.substring(11, 19), timeFormatter);
                LocalTime newStartTime = startTime.plusHours(1);
                LocalTime midNight = LocalTime.of(00, 00, 00);
                LocalTime almostMidNight = LocalTime.of(23, 59, 59);
                int oldTimeComparison = startTime.compareTo(almostMidNight);
                int newTimeComparison = newStartTime.compareTo(midNight);
                if (oldTimeComparison <= 0 && newTimeComparison >= 0) {//controllo se il dato preso è prima di almostMidNight e che newStartTime + 1 ora sia dopo midNight
                    gameDate=gameDate.plusDays(1);
                }
            }
            game.setGameDate(gameDate);
            game.setStartTime(startTime);
            game.setStage(asInteger(gameNode.get("stage")));
            game.setTotPeriods(asInteger(gameNode.get("periods").get("total")));
            game.setArena(arenaRepository.findBynameArena(gameNode.get("arena").get("name").asText()));
            game.setVisitorTeam(teamRepository.findById(gameNode.get("teams").get("visitors").get("id").asInt()));
            game.setHomeTeam(teamRepository.findById(gameNode.get("teams").get("home").get("id").asInt()));
            gameRepository.save(game);
            System.out.println("Object Game game saved in the DB");

            StatsGame statsGameVisitor = new StatsGame();
            statsGameVisitor.setTeam(teamRepository.findById(gameNode.get("teams").get("visitors").get("id").asInt()));
            statsGameVisitor.setGame(gameRepository.findById(gameNode.get("id").asInt()));
            statsGameVisitor.setWin(asInteger(gameNode.get("scores").get("visitors").get("win")));
            statsGameVisitor.setLose(asInteger(gameNode.get("scores").get("visitors").get("loss")));
            statsGameVisitor.setSeriesWin(asInteger(gameNode.get("scores").get("visitors").get("series").get("win")));
            statsGameVisitor.setSeriesLose(asInteger(gameNode.get("scores").get("visitors").get("series").get("loss")));
            statsGameVisitor.setPointsPeriod(gameNode.get("scores").get("visitors").get("linescore").asText(null));
            statsGameVisitor.setPoints(asInteger(gameNode.get("scores").get("visitors").get("points")));
            statsGameRepository.save(statsGameVisitor);
            System.out.println("Object StatsGame statsGameVisitor saved in the DB");

            StatsGame statsGameHome = new StatsGame();
            statsGameHome.setTeam(teamRepository.findById(gameNode.get("teams").get("visitors").get("id").asInt()));
            statsGameHome.setGame(gameRepository.findById(gameNode.get("id").asInt()));
            statsGameHome.setWin(asInteger(gameNode.get("scores").get("home").get("win")));
            statsGameHome.setLose(asInteger(gameNode.get("scores").get("home").get("loss")));
            statsGameHome.setSeriesWin(asInteger(gameNode.get("scores").get("home").get("series").get("win")));
            statsGameHome.setSeriesLose(asInteger(gameNode.get("scores").get("home").get("series").get("loss")));
            statsGameHome.setPointsPeriod(gameNode.get("scores").get("home").get("linescore").asText(null));
            statsGameHome.setPoints(asInteger(gameNode.get("scores").get("home").get("points")));
            statsGameRepository.save(statsGameHome);
            System.out.println("Object StatsGame statsGameHome saved in the DB");
        }
    }
}

