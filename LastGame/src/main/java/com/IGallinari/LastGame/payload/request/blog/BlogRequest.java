package com.IGallinari.LastGame.payload.request.blog;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogRequest {
    private String token;
    private int idBlog;
}
