package com.example.tdd.api;

import com.example.tdd.GameResult;
import com.example.tdd.GameService;
import com.example.tdd.Hand;
import com.example.tdd.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class GameApiTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GameService gameService;

    @Test
    void doBattle_okWithSingleBattle() throws Exception {

        // GIVEN
        Mockito.when(gameService.getGameResults("game-1")).thenReturn(GameResult.builder()
                .gameId("game-1")
                .battles(List.of(GameResult.Battle.builder()
                        .hand1(Hand.SCISSORS)
                        .hand2(Hand.PAPER)
                        .build()))
                .results(GameResult.Results.builder()
                        .hand1(1)
                        .hand2(0)
                        .winner(Result.PLAYER1_WINS)
                        .build())
                .build());

        // WHEN
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/games/{game-id}/battle/{hand-1}/{hand-2}",
                        "game-1",
                        "SCISSORS",
                        "PAPER"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // THEN
        String expected = """
                {
                    "gameId": "game-1",
                    "battles": [
                        { "hand1": "SCISSORS", "hand2": "PAPER" }
                    ],
                    "results": {
                        "hand1": 1,
                        "hand2": 0,
                        "winner": "PLAYER1_WINS"
                    }
                }
                """;

        Assertions.assertEquals("application/json", result.getResponse().getContentType());
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

    @Test
    void doBattle_okWithMultipleBattles() throws Exception {

        // GIVEN
        Mockito.when(gameService.getGameResults("game-1")).thenReturn(GameResult.builder()
                .gameId("game-23")
                .battles(List.of(GameResult.Battle.builder()
                        .hand1(Hand.PAPER)
                        .hand2(Hand.ROCK)
                        .build(), GameResult.Battle.builder()
                        .hand1(Hand.SCISSORS)
                        .hand2(Hand.ROCK)
                        .build(), GameResult.Battle.builder()
                        .hand1(Hand.SCISSORS)
                        .hand2(Hand.PAPER)
                        .build()))
                .results(GameResult.Results.builder()
                        .hand1(204)
                        .hand2(90)
                        .winner(Result.DRAW)
                        .build())
                .build());


        // WHEN
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/games/{game-id}/battle/{hand-1}/{hand-2}",
                        "game-1",
                        "SCISSORS",
                        "PAPER"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // THEN
        String expected = """
                {
                    "gameId": "game-23",
                    "battles": [
                        { "hand1": "PAPER", "hand2": "ROCK" },
                        { "hand1": "SCISSORS", "hand2": "ROCK" },
                        { "hand1": "SCISSORS", "hand2": "PAPER" }
                    ],
                    "results": {
                        "hand1": 204,
                        "hand2": 90,
                        "winner": "DRAW"
                    }
                }
                """;

        Assertions.assertEquals("application/json", result.getResponse().getContentType());
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

    @Test
    void doBattle_improperInputHandValues() throws Exception {

        // WHEN
        mockMvc.perform(MockMvcRequestBuilders.post("/games/{game-id}/battle/{hand-1}/{hand-2}",
                        "game-1",
                        "BLA",
                        "FOO"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
