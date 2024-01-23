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
/**
 * Service class for handling operations related to JSON Web Tokens (JWT).
 * This includes generating, decoding, and validating JWTs.
 */
@Service
public class JwtService {

    private final String secretKey ="5g8c<gjkTw*N7)0H8k//l}u@3~Rvan@nkay8R`G(aka!lt$zRAZ";
    private final int expirationTime = 5; // 10 days

    /**
     * Generates a JWT token for a user with specified credentials.
     *
     * @param idUser The user's ID.
     * @param email The user's email.
     * @param role The user's role.
     * @return A JWT token string.
     */
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
    /**
     * Decodes a JWT token to extract its claims.
     *
     * @param token The JWT token to decode.
     * @return The DecodedJWT object containing the token's claims.
     */
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
    /**
     * Extracts the user ID from the JWT token.
     *
     * @param token The JWT token from which the user ID is extracted.
     * @return The user ID as an integer.
     */
    public int getIdUser(String token) {
        DecodedJWT jwt = decodedJWT(token);
        return jwt.getClaim("idUser").asInt();
    }
    /**
     * Extracts the email from the JWT token.
     *
     * @param token The JWT token from which the email is extracted.
     * @return The email as a String.
     */
    public String getEmail(String token) {
        DecodedJWT jwt = decodedJWT(token);
        return jwt.getClaim("email").asString();
    }
    /**
     * Extracts the user role from the JWT token.
     *
     * @param token The JWT token from which the role is extracted.
     * @return The role as an integer.
     */
    public int getRole(String token) {
        DecodedJWT jwt = decodedJWT(token);
        return jwt.getClaim("role").asInt();
    }
    /**
     * Retrieves the expiration date of the JWT token.
     *
     * @param token The JWT token from which the expiration date is extracted.
     * @return The expiration date as a LocalDateTime object.
     */
    public LocalDateTime getExpireDate(String token) {
        DecodedJWT jwt = decodedJWT(token);
        Instant instant = jwt.getExpiresAt().toInstant();
        LocalDateTime expireDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return expireDate;
    }

    /**
     * Checks if a JWT token is valid.
     *
     * @param token The JWT token to validate.
     * @return A boolean value indicating whether the token is valid or not.
     */
    public boolean isTokenValid(String token) {
        if(token!=null) {
            try {
                Algorithm algorithm = Algorithm.HMAC256(secretKey);
                JWTVerifier verifier = JWT.require(algorithm).build();
                verifier.verify(token);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
