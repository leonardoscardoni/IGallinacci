package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.response.Calendar.CalendarResponse;
import com.IGallinari.LastGame.payload.response.Home.HomeResponse;
import com.IGallinari.LastGame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/games")
@CrossOrigin
public class GameController {

    @Autowired
    private GameService service;

    @PostMapping("/getHomeUnLogged")
    public HomeResponse getHomeUnLogged(){
        return this.service.buildHomeUnLogged();
    }

    @PostMapping("/getCalendar")
    public CalendarResponse getHomeUnLogged(LocalDate inputdate){
        return this.service.buildCalendar(inputdate);
    }
}
