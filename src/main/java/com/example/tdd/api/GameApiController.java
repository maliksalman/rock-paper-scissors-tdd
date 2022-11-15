package com.example.tdd.api;

import com.example.tdd.GameResult;
import com.example.tdd.GameService;
import com.example.tdd.Hand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/games")
public class GameApiController {

    private final GameService gameService;

    @PostMapping("/{gameId}/battle/{hand1}/{hand2}")
    public GameResult doBattle(@PathVariable String gameId,
                               @PathVariable Hand hand1,
                               @PathVariable Hand hand2) {

        gameService.battle(gameId, hand1, hand2);
        return gameService.getGameResults(gameId);
    }
}
