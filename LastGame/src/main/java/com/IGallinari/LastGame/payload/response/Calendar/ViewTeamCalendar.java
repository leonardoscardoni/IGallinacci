package com.IGallinari.LastGame.payload.response.Calendar;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTeamCalendar {
    private int id;
    private String nickname;
    private String logo;
}
