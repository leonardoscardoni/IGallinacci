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

}
