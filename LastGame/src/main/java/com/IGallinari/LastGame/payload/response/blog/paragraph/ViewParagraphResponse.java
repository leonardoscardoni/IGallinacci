package com.IGallinari.LastGame.payload.response.blog.paragraph;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewParagraphResponse {
    private String title;
    private String content;
}
