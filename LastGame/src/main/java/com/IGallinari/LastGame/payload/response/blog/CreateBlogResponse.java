package com.IGallinari.LastGame.payload.response.blog;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBlogResponse {
    private boolean succes;
    private String message;
}
