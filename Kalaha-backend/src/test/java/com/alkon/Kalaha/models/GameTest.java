package com.alkon.Kalaha.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Board board = new Board();
    List<Pit> pits = new ArrayList<>();

    Player player1 = new Player("p1");
    Player player2 = new Player("p2");

    @BeforeEach
    void setUp() {
        pits.add(0, new Pit(0, 0, "lp2"));
        for (int i = 1; i < 7; i++) {
            pits.add(new Pit(i, 6, "p1"));
        }
        pits.add(7, new Pit(7, 0, "lp1"));
        for (int i = 8; i < 14; i++) {
            pits.add(new Pit(i, 6, "p2"));
        }
        board.setBoardPits(pits);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void playersTurn() {
    }

    @Test
    void sowing() {
    }

    @Test
    void sow() {
        Game game = new Game();
        game.sow(board.getBoardPits().get(2), player2.getPlayerLargePitTag());
        assertEquals(7, board.getBoardPits().get(2).getRocks());
    }

    @Test
    void setStartingPitRocksToZero() {
    }

    @Test
    void gameResolve() {
    }

    @Test
    void canCaptureOppositePitsRocks() {
    }


}
