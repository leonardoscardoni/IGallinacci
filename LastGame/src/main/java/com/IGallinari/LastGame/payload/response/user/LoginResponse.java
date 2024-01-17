package com.IGallinari.LastGame.payload.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LoginResponse {
    private boolean success;
    private String message;
    private String token;
    private LocalDateTime expireDate;
    private String name;
}
