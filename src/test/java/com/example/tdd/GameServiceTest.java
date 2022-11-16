package com.example.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameServiceTest {

    @Test
    void battle_withOneBattle() {

        // GIVEN
        GameService service = new GameService();

        // WHEN
        service.battle("1234", Hand.SCISSORS, Hand.PAPER);

        // THEN
        Game game = service.findGame("1234");
        assertNotNull(game);
        assertEquals("1234", game.getGameId());
        assertEquals(1, game.getBattles().size());

        Game.Battle battle = game.getBattles().get(0);
        assertEquals(Hand.SCISSORS, battle.getHand1());
        assertEquals(Hand.PAPER, battle.getHand2());

        assertNotNull(game.getSummary());
    }


}