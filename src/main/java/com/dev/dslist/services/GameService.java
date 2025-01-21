package com.dev.dslist.services;

import com.dev.dslist.dto.GameMinDTO;
import com.dev.dslist.entities.Game;
import com.dev.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameMinDTO findById(@PathVariable Long listId) {
        Game result = gameRepository.findById(listId).get();
        return new GameMinDTO(result);
    }

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> gameMinDTO = result.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
        return gameMinDTO;
    }
}