package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.Game;
import com.IGallinari.LastGame.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private GameRepository gameRepository;


}