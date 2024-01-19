package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.response.calendar.CalendarResponse;
import com.IGallinari.LastGame.payload.response.home.HomeResponse;
import com.IGallinari.LastGame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/game")
@CrossOrigin
public class GameController {

    @Autowired
    private GameService service;

    @RequestMapping("/getHomeUnLogged")
    public HomeResponse getHomeUnLogged(){return this.service.buildHomeUnLogged();}

    @RequestMapping("/getCalendar")
    public CalendarResponse getCalendar(@RequestParam LocalDate date){
        return this.service.buildCalendar(date);
    }

    @RequestMapping("/getGameDetails")
    public ResponseEntity<?> getGameDetails(@RequestParam int idGame){return this.service.buildGameDetails(idGame);}
}
