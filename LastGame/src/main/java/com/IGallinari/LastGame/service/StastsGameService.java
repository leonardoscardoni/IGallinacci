package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.entity.StatsGame;
import com.IGallinari.LastGame.repository.StatsGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StastsGameService {

    private StatsGameRepository statsGameRepository;

    public List<StatsGame> getGamesHome(){
        LocalDate inputDate = LocalDate.of(2023,12,19);
        return statsGameRepository.findStatsGameByGameGameDate(inputDate);
    }
}
