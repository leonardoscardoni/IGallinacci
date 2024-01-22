package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.request.blog.BlogRequest;
import com.IGallinari.LastGame.payload.request.blog.CreateBlogRequest;
import com.IGallinari.LastGame.payload.response.blog.BlogResponse;
import com.IGallinari.LastGame.payload.response.blog.CreateBlogResponse;
import com.IGallinari.LastGame.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
@CrossOrigin
public class BlogController {

    @Autowired
    private BlogService service;

    @PostMapping("/create")
    public CreateBlogResponse createBlog(@RequestBody CreateBlogRequest createBlogRequest) {return this.service.saveBlog(createBlogRequest);}

    @PostMapping("getBlog")
    public BlogResponse getBlog(@RequestBody TokenRequest tokenRequest, @RequestParam int idBlog) {return this.service.getBlog(tokenRequest,idBlog);}

}
