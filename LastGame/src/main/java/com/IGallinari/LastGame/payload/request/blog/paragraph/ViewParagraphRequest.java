package com.IGallinari.LastGame.payload.request.blog.paragraph;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ViewParagraphRequest {
    private String title;
    private String content;
}
