package com.IGallinari.LastGame.payload.request.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SigninRequest {
    private String email;
    private String password;
    private String name;
}
