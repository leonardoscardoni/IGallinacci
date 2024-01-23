package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.request.blog.CreateBlogRequest;
import com.IGallinari.LastGame.payload.response.blog.BlogResponse;
import com.IGallinari.LastGame.payload.response.blog.CreateBlogResponse;
import com.IGallinari.LastGame.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling blog-related operations.
 * This class is annotated with {@code @RestController} to indicate that it is a controller providing RESTful services.
 * The base mapping for the endpoints is set using {@code @RequestMapping("/blog")}.
 * Cross-origin requests are allowed through the {@code @CrossOrigin} annotation.
 */
@RestController
@RequestMapping("/blog")
@CrossOrigin
public class BlogController {

    /**
     * Autowired field for injecting the BlogService dependency.
     */
    @Autowired
    private BlogService service;

    /**
     * Endpoint for creating a new blog.
     *
     * @param createBlogRequest The request object containing information for creating a new blog.
     * @return The response containing information about the created blog.
     */
    @PostMapping("/create")
    public CreateBlogResponse createBlog(@RequestBody CreateBlogRequest createBlogRequest) {
        return this.service.saveBlog(createBlogRequest);
    }

    /**
     * Endpoint for retrieving a specific blog.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @param idBlog       The identifier of the blog to retrieve.
     * @return The response containing information about the requested blog.
     */
    @PostMapping("/getBlog")
    public BlogResponse getBlog(@RequestBody TokenRequest tokenRequest, @RequestParam int idBlog) {
        return this.service.getBlog(tokenRequest, idBlog);
    }

    /**
     * Endpoint for retrieving all blogs.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @return The ResponseEntity containing a list of all blogs or an error response.
     */
    @PostMapping("/getAllBlogs")
    public ResponseEntity<?> getAllBlogs(@RequestBody TokenRequest tokenRequest) {
        return this.service.getAllBlogs(tokenRequest);
    }
}
