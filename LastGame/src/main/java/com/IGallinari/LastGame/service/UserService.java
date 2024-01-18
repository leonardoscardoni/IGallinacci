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

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtService  jwtService;

    private final UserRepository userRepository;
    private final FavPlayerRepository favPlayersRepository;
    private final FavTeamRepository favTeamRepository;

    private final PlayerRepository playerRepository;
    private final StatsPlayerRepository statsPlayerRepository;
    private final TeamRepository teamRepository;


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
    public NeedToBeLoggedResponse needToBeLogged(){
        return new NeedToBeLoggedResponse();
    }
    public ProfileResponse buildLoggedProfile(User user) {
        List<ViewFavoritePlayerProfileResponse> favPlayers = new ArrayList<>();
        List<ViewFavoriteTeamProfileResponse> favTeams = new ArrayList<>();
        List<Integer> idPlayers = favPlayersRepository.findFavPlayersByUser(user.getId());
        List<Integer> IdTeams = favTeamRepository.findFavTeamsByUser(user.getId());

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

        for (int idTeam: IdTeams
        ) {
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
