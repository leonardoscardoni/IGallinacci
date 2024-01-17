package com.IGallinari.LastGame.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@Service
public class JwtService {

    private final String secretKey ="5g8c<gjkTw*N7)0H8k//l}u@3~Rvan@nkay8R`G(aka!lt$zRAZ";
    private final int expirationTime = 5; // 10 days


    public String generateToken(int idUser,String email, int role) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            String token = JWT.create()
                    .withClaim("idUser", idUser)
                    .withClaim("email", email)
                    .withClaim("role", role)
                    .withIssuedAt(Instant.now())
                    .withExpiresAt(Instant.now().plus(expirationTime, ChronoUnit.DAYS)) // Claim exp
                    .sign(algorithm);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public DecodedJWT decodedJWT(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            return verifier.verify(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getIdUser(String token) {
        DecodedJWT jwt = decodedJWT(token);
        return jwt.getClaim("idUser").asInt();
    }

    public String getEmail(String token) {
        DecodedJWT jwt = decodedJWT(token);
        return jwt.getClaim("email").asString();
    }

    public int getRole(String token) {
        DecodedJWT jwt = decodedJWT(token);
        return jwt.getClaim("role").asInt();
    }

    public LocalDateTime getExpireDate(String token) {
        DecodedJWT jwt = decodedJWT(token);
        Instant instant = jwt.getExpiresAt().toInstant();
        LocalDateTime expireDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return expireDate;
    }


    public boolean isTokenValid(String token) {
        if(token!=null) {
            try {
                Algorithm algorithm = Algorithm.HMAC256(secretKey);
                JWTVerifier verifier = JWT.require(algorithm).build();
                verifier.verify(token);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
