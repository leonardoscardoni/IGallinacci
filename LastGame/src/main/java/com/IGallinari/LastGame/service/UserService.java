package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.entity.User;
import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.request.user.LoginRequest;
import com.IGallinari.LastGame.payload.request.user.SigninRequest;
import com.IGallinari.LastGame.payload.response.NeedToBeLoggedResponse;
import com.IGallinari.LastGame.payload.response.user.LoginResponse;
import com.IGallinari.LastGame.payload.response.user.SigninResponse;
import com.IGallinari.LastGame.payload.response.user.profile.ProfileResponse;
import com.IGallinari.LastGame.payload.response.user.profile.ViewFavoritePlayerProfileResponse;
import com.IGallinari.LastGame.payload.response.user.profile.ViewFavoriteTeamProfileResponse;
import com.IGallinari.LastGame.payload.response.user.profile.ViewStatisticsFavPlayerProfileResponse;
import com.IGallinari.LastGame.repository.*;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/**
 * This service class provides methods for user authentication, registration,
 * and profile management, including favorite players and teams.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtService  jwtService;

    private final UserRepository userRepository;
    private final FavPlayerRepository favPlayerRepository;
    private final FavTeamRepository favTeamRepository;
    private final PlayerRepository playerRepository;
    private final StatsPlayerRepository statsPlayerRepository;
    private final TeamRepository teamRepository;
    /**
     * Checks if the provided email address is valid.
     *
     * @param email The email address to validate.
     * @return True if the email is valid; otherwise, false.
     */
    private boolean emailIsValid(String email) {
        String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        return pattern.matcher(email.trim()).matches();
    }
    /**
     * Handles user login by verifying credentials and generating a JWT token.
     *
     * @param loginRequest The login request containing email and password.
     * @return A LoginResponse with the result of the login attempt.
     */
    public LoginResponse login(LoginRequest loginRequest) {
        if(!emailIsValid(loginRequest.getEmail())) {
            return new LoginResponse(false, "Email not valid", null, null, null);
        }
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
    /**
     * Handles user registration by creating a new user account.
     *
     * @param signinRequest The registration request containing user details.
     * @return A SigninResponse with the result of the registration attempt.
     */
    public SigninResponse signin(SigninRequest signinRequest) {
        if(!emailIsValid(signinRequest.getEmail())) {
            return new SigninResponse(false, "Email not valid");
        }
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
    /**
     * Builds the user profile response including favorite players and teams.
     *
     * @param tokenRequest The token request containing the user's authentication token.
     * @return A ResponseEntity containing the user's profile information.
     */
    public ResponseEntity<?> buildProfile(TokenRequest tokenRequest){
        String token = tokenRequest.getToken();
        if(jwtService.isTokenValid(token)){
            int idUser = jwtService.getIdUser(token);
            User user = userRepository.findById(idUser);
            return ResponseEntity.ok(buildLoggedProfile(user));
        }else {
            return ResponseEntity.ok(needToBeLogged());
        }
    }
    /**
     * Generates a response indicating the need for the user to log in.
     *
     * @return A NeedToBeLoggedResponse indicating the user needs to log in.
     */
    public NeedToBeLoggedResponse needToBeLogged(){
        return new NeedToBeLoggedResponse();
    }
    /**
     * Builds the profile response for a logged-in user, including favorite players and teams.
     *
     * @param user The logged-in user for whom the profile is built.
     * @return A ProfileResponse containing user profile information.
     */
    public ProfileResponse buildLoggedProfile(User user) {
        List<ViewFavoritePlayerProfileResponse> favPlayers = new ArrayList<>();
        List<ViewFavoriteTeamProfileResponse> favTeams = new ArrayList<>();
        List<Integer> idPlayers = favPlayerRepository.findFavPlayersByUser(user.getId());
        List<Integer> idTeams = favTeamRepository.findFavTeamsByUser(user.getId());

        for (int idPlayer: idPlayers
             ) {
            List<Float[]> avgStatPlayer = statsPlayerRepository.findAvgStatsByIdPlayer(idPlayer);
            ViewStatisticsFavPlayerProfileResponse statFavPlayer = new ViewStatisticsFavPlayerProfileResponse(
                    avgStatPlayer.get(0)[0],
                    avgStatPlayer.get(0)[1],
                    avgStatPlayer.get(0)[2],
                    avgStatPlayer.get(0)[3]
            );
            Player player = playerRepository.findById(idPlayer);
            favPlayers.add(new ViewFavoritePlayerProfileResponse(
                    player.getId(),
                    player.getFirstname(),
                    player.getLastname(),
                    player.getJersey(),
                    Player.getRole(player.getPos()),
                    statFavPlayer
            ));
        }

        for (int idTeam: idTeams) {
            Team team = teamRepository.findById(idTeam);
            favTeams.add(new ViewFavoriteTeamProfileResponse(
                    team.getId(),
                    team.getNickname(),
                    team.getLogo()
            ));
        }

        ProfileResponse profileResponse = new ProfileResponse(
                user.getId(),
                user.getName(),
                favPlayers,
                favTeams
                );
        return profileResponse;
    }
}
