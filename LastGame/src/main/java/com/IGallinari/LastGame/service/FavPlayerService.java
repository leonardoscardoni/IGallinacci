package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.FavPlayer;
import com.IGallinari.LastGame.entity.Player;
import com.IGallinari.LastGame.entity.User;
import com.IGallinari.LastGame.entity.id_class.IdFavPlayer;
import com.IGallinari.LastGame.payload.request.favourite.player.FavPlayerRequest;
import com.IGallinari.LastGame.payload.response.NeedToBeLoggedResponse;
import com.IGallinari.LastGame.payload.response.favourite.player.FavPlayerResponse;
import com.IGallinari.LastGame.repository.FavPlayerRepository;
import com.IGallinari.LastGame.repository.PlayerRepository;
import com.IGallinari.LastGame.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class FavPlayerService {
    private final FavPlayerRepository favPlayerRepository;
    private final JwtService jwtService;
    private final PlayerRepository playerRepository;
    private final UserRepository userRepository;


    public ResponseEntity<?> buildFavPlayerResponse (FavPlayerRequest favPlayerRequest){
        String token = favPlayerRequest.getToken();
        boolean logged= jwtService.isTokenValid(token);
        if(!logged){
            return ResponseEntity.ok(new NeedToBeLoggedResponse());
        }
        int idUser = jwtService.getIdUser(token);
        int idPlayer = favPlayerRequest.getIdPlayer();
        User user = userRepository.findById(idUser);
        Player player = playerRepository.findById(idPlayer);
        boolean favourite;
        boolean exist = favPlayerRepository.existsByIdUserAndIdPlayer(idUser, idPlayer)==1;
        if (exist){
            FavPlayer favPlayer = favPlayerRepository.findByUserAndPlayer(user, player);
            favPlayerRepository.delete(favPlayer);
            favourite=false;
        }
        else {
            IdFavPlayer idFavPlayer = new IdFavPlayer();
            idFavPlayer.setIdUser(idUser);
            idFavPlayer.setPlayerId(idPlayer);
            FavPlayer favPlayer = new FavPlayer();
            favPlayer.setIdFavPlayer(idFavPlayer);
            favPlayerRepository.save(favPlayer);
            favourite=true;
        }
        return ResponseEntity.ok(new FavPlayerResponse(idPlayer, favourite));
    }
}
