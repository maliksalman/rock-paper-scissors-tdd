package com.example.tdd;

import com.example.tdd.Hand;
import com.example.tdd.Result;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class GameResult {

    private String gameId;
    private List<Battle> battles;
    private Results results;


    @Builder
    @Value
    public static class Battle {
        private Hand hand1;
        private Hand hand2;
    }

    @Builder
    @Value
    public static class Results {
        private int hand1;
        private int hand2;
        private Result winner;
    }
}
