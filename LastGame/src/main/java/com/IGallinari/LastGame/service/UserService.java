package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.entity.User;
import com.IGallinari.LastGame.payload.request.user.LoginRequest;
import com.IGallinari.LastGame.payload.request.user.SigninRequest;
import com.IGallinari.LastGame.payload.response.user.LoginResponse;
import com.IGallinari.LastGame.payload.response.user.SigninResponse;
import com.IGallinari.LastGame.payload.response.user.profile.ProfileResponse;
import com.IGallinari.LastGame.payload.response.user.profile.ViewFavoritePlayerProfileResponse;
import com.IGallinari.LastGame.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtService  jwtService;

    private final UserRepository userRepository;


    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null) {
            boolean passwordMatch = BCrypt.checkpw(loginRequest.getPassword(), user.getPassword());
            if (passwordMatch) {
                String token = jwtService.generateToken(user.getId(), user.getEmail(), user.getRole());
                LocalDateTime expireDate = jwtService.getExpireDate(token);
                return new LoginResponse(true, "Login successful", token, expireDate, user.getName());
            } else {
                return new LoginResponse(false, "Password not valid", null, null, null);
            }
        }else {
            return new LoginResponse(false, "Email not found", null, null, null);
        }
    }

    public SigninResponse signin(SigninRequest signinRequest) {
        if (!userRepository.existsByEmail(signinRequest.getEmail())) {
            User user = new User();
            user.setEmail(signinRequest.getEmail());
            user.setName(signinRequest.getName());
            user.setPassword(BCrypt.hashpw(signinRequest.getPassword(),BCrypt.gensalt()));
            if (signinRequest.getEmail().contains("@edu.itspiemonte.it")) {
                user.setRole(1);
            }else{
                user.setRole(0);
            }
            userRepository.save(user);
            return new SigninResponse(true,"Account created");
        }else{
            return new SigninResponse(false, "Email already exists");
        }
    }

}
