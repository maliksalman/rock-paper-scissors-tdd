package com.example.tdd;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Game {

    private String gameId;
    private List<Battle> battles;
    private Summary summary;


    @Builder
    @Data
    public static class Battle {
        private Hand hand1;
        private Hand hand2;
    }

    @Builder
    @Data
    public static class Summary {
        private int hand1;
        private int hand2;
        private Result winner;
    }
}
