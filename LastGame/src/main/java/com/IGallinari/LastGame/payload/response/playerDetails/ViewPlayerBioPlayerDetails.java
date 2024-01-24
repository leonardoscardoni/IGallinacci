package com.IGallinari.LastGame.payload.response.playerDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ViewPlayerBioPlayerDetails {
    private Integer age;
    private String country;
    private Float weight;
    private Float height;
    private String pos;
    private Integer startYearNba;
    private String college;
    private String affiliation;
}
