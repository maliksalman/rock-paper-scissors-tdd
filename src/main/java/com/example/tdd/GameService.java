package com.example.tdd;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class GameService {

    private Map<String, Game> games = new HashMap<>();

    public void battle(String gameId, Hand hand1, Hand hand2) {

        Game game = games.get(gameId);
        if (game == null) {
            game = Game.builder()
                    .gameId(gameId)
                    .battles(new ArrayList<>())
                    .summary(Game.Summary.builder().build())
                    .build();
            games.put(gameId, game);
        }

        game.getBattles().add(new Game.Battle(hand1, hand2));
    }

    public Game findGame(String gameId) {
        return games.get(gameId);
    }
}
