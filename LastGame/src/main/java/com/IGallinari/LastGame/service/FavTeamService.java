package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.FavTeam;
import com.IGallinari.LastGame.entity.Team;
import com.IGallinari.LastGame.entity.User;
import com.IGallinari.LastGame.entity.id_class.IdFavTeam;
import com.IGallinari.LastGame.payload.request.favourite.team.FavTeamRequest;
import com.IGallinari.LastGame.payload.response.NeedToBeLoggedResponse;
import com.IGallinari.LastGame.payload.response.favourite.team.FavTeamResponse;
import com.IGallinari.LastGame.repository.FavTeamRepository;
import com.IGallinari.LastGame.repository.TeamRepository;
import com.IGallinari.LastGame.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
/**
 * Service class for managing favorite team functionalities.
 * This includes operations such as adding or removing a team from a user's favorites.
 */
@Service
@RequiredArgsConstructor
public class FavTeamService {

    private final FavTeamRepository favTeamRepository;

    private final UserRepository userRepository;

    private final TeamRepository teamRepository;

    private final JwtService jwtService;
    /**
     * Builds and returns the favorite team response based on the given request.
     * This method checks if a team is a favorite for a user and adds/removes it accordingly.
     *
     * @param favTeamRequest The request containing the user's token and the team's ID.
     * @return A ResponseEntity containing the favorite team response.
     */
    public ResponseEntity<?> buildFavTeamResponse(FavTeamRequest favTeamRequest){
        String token = favTeamRequest.getToken();
        boolean logged= jwtService.isTokenValid(token);
        if(!logged){
            return ResponseEntity.ok(new NeedToBeLoggedResponse());
        }
        int idUser = jwtService.getIdUser(token);
        int idTeam = favTeamRequest.getIdTeam();

        User user = userRepository.findById(idUser);
        Team team = teamRepository.findById(idTeam);

        boolean favourite;
        boolean exist = favTeamRepository.existsByIdUserAndIdTeam(idUser,idTeam) ==1;
        if(exist){
            FavTeam favTeam = favTeamRepository.findByUserAndTeam(user, team);
            favTeamRepository.delete(favTeam);
            favourite = false;
        }else{
            IdFavTeam idFavTeam = new IdFavTeam();
            idFavTeam.setIdUser(idUser);
            idFavTeam.setIdTeam(idTeam);
            FavTeam favTeam = new FavTeam();
            favTeam.setIdFavTeam(idFavTeam);
            favTeamRepository.save(favTeam);
            favourite = true;
        }
        return ResponseEntity.ok(new FavTeamResponse(idTeam, favourite));
    }
}
