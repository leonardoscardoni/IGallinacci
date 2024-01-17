package com.IGallinari.LastGame.payload.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SigninResponse {
    private boolean success;
    private String message;
}
