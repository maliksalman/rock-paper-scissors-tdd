package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RPSTest {

    @Test
    void testRockVsRock_draw() {
        Result result = new RPS().battle(Hand.ROCK, Hand.ROCK);
        Assertions.assertEquals(Result.DRAW, result);
    }

    @Test
    void testRockVsPaper_player2Wins() {
        Result result = new RPS().battle(Hand.ROCK, Hand.PAPER);
        Assertions.assertEquals(Result.PLAYER2_WINS, result);
    }

    @Test
    void testRockVsScissors_player1Wins() {
        Result result = new RPS().battle(Hand.ROCK, Hand.SCISSORS);
        Assertions.assertEquals(Result.PLAYER1_WINS, result);
    }

    @Test
    void testScissorsVsScissors_draw() {
        Result result = new RPS().battle(Hand.SCISSORS, Hand.SCISSORS);
        Assertions.assertEquals(Result.DRAW, result);
    }

    @Test
    void testScissorsVsPaper_player1Wins() {
        Result result = new RPS().battle(Hand.SCISSORS, Hand.PAPER);
        Assertions.assertEquals(Result.PLAYER1_WINS, result);
    }

    @Test
    void testScissorsVsRock_player2Wins() {
        Result result = new RPS().battle(Hand.SCISSORS, Hand.ROCK);
        Assertions.assertEquals(Result.PLAYER2_WINS, result);
    }

    @Test
    void testPaperVsPaper_draw() {
        Result result = new RPS().battle(Hand.PAPER, Hand.PAPER);
        Assertions.assertEquals(Result.DRAW, result);
    }

    @Test
    void testPaperVsRock_player1Wins() {
        Result result = new RPS().battle(Hand.PAPER, Hand.ROCK);
        Assertions.assertEquals(Result.PLAYER1_WINS, result);
    }

    @Test
    void testPaperVsScissors_player2Wins() {
        Result result = new RPS().battle(Hand.PAPER, Hand.SCISSORS);
        Assertions.assertEquals(Result.PLAYER2_WINS, result);
    }




}
