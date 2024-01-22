package com.IGallinari.LastGame.payload.response.blog;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class AllBlogLoggedResponse {
    private boolean logged;
    private List<ViewBlog> blogsAboutYourInterests;
    private List<ViewBlog> blogs;
}
