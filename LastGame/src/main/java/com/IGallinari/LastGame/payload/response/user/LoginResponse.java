package com.IGallinari.LastGame.payload.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LoginResponse {
    private boolean success;
    private String message;
    private String token;
    private LocalDate expireDate;
    private String name;
}
