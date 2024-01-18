package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.request.home.HomeRequest;
import com.IGallinari.LastGame.payload.response.calendar.CalendarResponse;
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

    @PostMapping("/getHome")
    public ResponseEntity<?> getHome(@RequestBody HomeRequest homeRequest){return this.service.buildHome(homeRequest);}

    @RequestMapping("/getCalendar")
    public CalendarResponse getCalendar(@RequestParam LocalDate date){
        return this.service.buildCalendar(date);
    }

    @RequestMapping("/getGameDetails")
    public ResponseEntity<?> getGameDetails(@RequestParam int idGame){return this.service.buildGameDetails(idGame);}
}
