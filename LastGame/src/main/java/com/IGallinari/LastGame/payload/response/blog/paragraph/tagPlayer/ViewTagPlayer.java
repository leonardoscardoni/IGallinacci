package com.IGallinari.LastGame.payload.response.blog.paragraph.tagPlayer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewTagPlayer {
    private int idPlayer;
    private String firstname;
    private String lastname;
}
