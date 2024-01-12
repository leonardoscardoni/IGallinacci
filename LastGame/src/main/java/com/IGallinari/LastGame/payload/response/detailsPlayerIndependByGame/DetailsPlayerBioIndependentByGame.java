package com.IGallinari.LastGame.payload.response.detailsPlayerIndependByGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailsPlayerBioIndependentByGame {
    private Integer age;
    private String country;
    private Integer weight;
    private Integer height;
    private String pos;
    private Integer startYearNba;
    private String college;
    private String affiliation;
}
