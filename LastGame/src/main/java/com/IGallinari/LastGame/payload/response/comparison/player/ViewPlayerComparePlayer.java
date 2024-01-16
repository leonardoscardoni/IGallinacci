package com.IGallinari.LastGame.payload.response.comparison.player;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ViewPlayerComparePlayer {
    private String name;
    private Integer age;
    private String country;
    private Float weight;
    private Float height;
    private String team;
    private int debut;
    private String college;
    private String affiliation;
    private String role;
}
