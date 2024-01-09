package com.IGallinari.LastGame.payload.response.Calendar;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CalendarResponse {
    List<ViewGameCalendar> game;
}
