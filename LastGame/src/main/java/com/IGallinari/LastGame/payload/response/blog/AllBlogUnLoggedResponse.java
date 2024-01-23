package com.IGallinari.LastGame.payload.response.blog;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AllBlogUnLoggedResponse {
    private boolean logged;
    private List<ViewBlog> blogs;
}
