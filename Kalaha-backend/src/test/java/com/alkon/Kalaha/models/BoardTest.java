package com.alkon.Kalaha.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
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
        pits.get(6).setRocks(8);
        pits.get(13).setRocks(8);
    }

    @Test
    void findEndPitSimpleCase() {
    Board board = new Board(pits,pits.get(1),player1);
    Pit endPit = board.findEndPit();
    assertEquals(pits.get(7),endPit);
    assertEquals(pits.get(7).getId(),endPit.getId());
    }

    @Test
    void findEndPitSimpleCase1() {
        Board board = new Board(pits,pits.get(6),player1);
        Pit endPit = board.findEndPit();
        assertEquals(pits.get(1),endPit);
        assertEquals(pits.get(1).getId(),endPit.getId());
    }
    @Test
    void findEndPitSimpleCase2() {
        Board board = new Board(pits,pits.get(13),player2);
        Pit endPit = board.findEndPit();
        assertEquals(pits.get(8),endPit);
        assertEquals(pits.get(8).getId(),endPit.getId());
    }
}
