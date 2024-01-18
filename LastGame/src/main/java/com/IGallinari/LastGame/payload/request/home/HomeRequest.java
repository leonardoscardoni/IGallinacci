package com.IGallinari.LastGame.payload.request.home;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class HomeRequest {
    private String token;
    private LocalDate date;
}