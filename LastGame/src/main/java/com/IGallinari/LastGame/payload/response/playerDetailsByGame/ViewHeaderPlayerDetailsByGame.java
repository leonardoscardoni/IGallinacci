package com.IGallinari.LastGame.payload.response.playerDetailsByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor

public class ViewHeaderPlayerDetailsByGame {
    private String arena;
    private String city;
    private LocalDate date;
    private LocalTime time;




}
