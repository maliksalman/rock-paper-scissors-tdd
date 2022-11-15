package com.example.tdd;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    public void battle(String gameId, Hand hand1, Hand hand2) {

    }

    public GameResult getGameResults(String gameId) {
        return GameResult.builder().build();
    }
}
