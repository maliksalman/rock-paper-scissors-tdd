package com.example.tdd;

public class RPS {
    public Result battle(Hand hand1, Hand hand2) {

        if ((hand1 == Hand.PAPER && hand2 == Hand.ROCK) ||
                (hand1 == Hand.ROCK && hand2 == Hand.SCISSORS) ||
                (hand1 == Hand.SCISSORS && hand2 == Hand.PAPER)) {
            return Result.PLAYER1_WINS;
        }

        if ((hand1 == Hand.PAPER && hand2 == Hand.SCISSORS) ||
                (hand1 == Hand.ROCK && hand2 == Hand.PAPER) ||
                (hand1 == Hand.SCISSORS && hand2 == Hand.ROCK)) {
            return Result.PLAYER2_WINS;
        }

        return Result.DRAW;
    }
}
