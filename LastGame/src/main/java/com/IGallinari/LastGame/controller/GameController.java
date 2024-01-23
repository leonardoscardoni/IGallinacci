package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.request.home.HomeRequest;
import com.IGallinari.LastGame.payload.response.calendar.CalendarResponse;
import com.IGallinari.LastGame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * Controller class for handling game-related operations.
 * This class is annotated with {@code @RestController} to indicate that it is a controller providing RESTful services.
 * The base mapping for the endpoints is set using {@code @RequestMapping("/game")}.
 * Cross-origin requests are allowed through the {@code @CrossOrigin} annotation.
 */
@RestController
@RequestMapping("/game")
@CrossOrigin
public class GameController {

    /**
     * Autowired field for injecting the GameService dependency.
     */
    @Autowired
    private GameService service;

    /**
     * Endpoint for retrieving home-related information.
     *
     * @param homeRequest The request object containing information for retrieving home-related data.
     * @return The ResponseEntity containing home-related information or an error response.
     */
    @PostMapping("/getHome")
    public ResponseEntity<?> getHome(@RequestBody HomeRequest homeRequest) {
        return this.service.buildHome(homeRequest);
    }

    /**
     * Endpoint for retrieving calendar-related information.
     *
     * @param date The date for which calendar information is requested.
     * @return The CalendarResponse containing information about games on the specified date.
     */
    @RequestMapping("/getCalendar")
    public CalendarResponse getCalendar(@RequestParam LocalDate date) {
        return this.service.buildCalendar(date);
    }

    /**
     * Endpoint for retrieving detailed information about a specific game.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @param idGame       The identifier of the game for which details are requested.
     * @return The ResponseEntity containing detailed information about the requested game or an error response.
     */
    @PostMapping("/getGameDetails")
    public ResponseEntity<?> getGameDetails(@RequestBody TokenRequest tokenRequest, @RequestParam int idGame) {
        return this.service.buildGameDetails(tokenRequest, idGame);
    }
}
