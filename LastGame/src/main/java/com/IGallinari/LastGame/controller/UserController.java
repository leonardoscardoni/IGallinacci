package com.IGallinari.LastGame.controller;

import com.IGallinari.LastGame.payload.request.user.LoginRequest;
import com.IGallinari.LastGame.payload.request.user.SigninRequest;
import com.IGallinari.LastGame.payload.response.user.LoginResponse;
import com.IGallinari.LastGame.payload.response.user.SigninResponse;
import com.IGallinari.LastGame.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private UserService service;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){return this.service.login(loginRequest);}

    public SigninResponse signin(@RequestBody SigninRequest signinRequest){return this.service.signin(signinRequest);}
}
