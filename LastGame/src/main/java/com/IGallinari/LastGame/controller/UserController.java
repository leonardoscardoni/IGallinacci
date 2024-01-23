package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.request.user.LoginRequest;
import com.IGallinari.LastGame.payload.request.user.SigninRequest;
import com.IGallinari.LastGame.payload.response.user.LoginResponse;
import com.IGallinari.LastGame.payload.response.user.SigninResponse;
import com.IGallinari.LastGame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling user-related operations.
 * This class is annotated with {@code @RestController} to indicate that it is a controller providing RESTful services.
 * The base mapping for the endpoints is set using {@code @RequestMapping("/user")}.
 * Cross-origin requests are allowed through the {@code @CrossOrigin} annotation.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    /**
     * Autowired field for injecting the UserService dependency.
     */
    @Autowired
    private UserService service;

    /**
     * Endpoint for user login.
     *
     * @param loginRequest The request object containing user login credentials.
     * @return The LoginResponse containing the result of the login operation or an error response.
     */
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return this.service.login(loginRequest);
    }

    /**
     * Endpoint for user registration (sign-in).
     *
     * @param signinRequest The request object containing user registration details.
     * @return The SigninResponse containing the result of the registration operation or an error response.
     */
    @PostMapping("/signin")
    public SigninResponse signin(@RequestBody SigninRequest signinRequest) {
        return this.service.signin(signinRequest);
    }

    /**
     * Endpoint for retrieving user profile information.
     *
     * @param tokenRequest The request object containing the user's authentication token.
     * @return The ResponseEntity containing user profile information or an error response.
     */
    @RequestMapping("/getUserProfile")
    public ResponseEntity<?> getUserProfile(@RequestBody TokenRequest tokenRequest) {
        return this.service.buildProfile(tokenRequest);
    }
}
