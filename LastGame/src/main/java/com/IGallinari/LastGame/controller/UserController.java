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

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){return this.service.login(loginRequest);}

    @PostMapping("/signin")
    public SigninResponse signin(@RequestBody SigninRequest signinRequest){return this.service.signin(signinRequest);}

    @RequestMapping("getUserProfile")
    public ResponseEntity<?> getUserProfile(@RequestBody TokenRequest tokenRequest){return this.service.buildProfile(tokenRequest);}
}
