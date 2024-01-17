package com.IGallinari.LastGame.payload.response.home.blog;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ViewBlogHome {
    private int idBlog;
    private String title;
    private String subtitle;
    private String img;
    private LocalDate date;
}
