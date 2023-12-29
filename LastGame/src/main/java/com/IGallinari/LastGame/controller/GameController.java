package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.response.Calendar.CalendarResponse;
import com.IGallinari.LastGame.payload.response.Home.HomeResponse;
import com.IGallinari.LastGame.payload.response.NextGame.NextGameResponse;
import com.IGallinari.LastGame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/games")
@CrossOrigin
public class GameController {

    @Autowired
    private GameService service;

    @RequestMapping("/getHomeUnLogged")
    public HomeResponse getHomeUnLogged(){
        return this.service.buildHomeUnLogged();
    }

    @PostMapping("/getCalendar")
    public CalendarResponse getHomeUnLogged(@RequestParam LocalDate date){
        return this.service.buildCalendar(date);
    }

    @PostMapping("/getGameDetails")
    public NextGameResponse getNextGameDetails(@RequestParam int idGame){return this.service.buildNextGame(idGame);}


}
