package com.alkon.Kalaha.services;

import com.alkon.Kalaha.models.Game;
import com.alkon.Kalaha.models.GameState;
import com.alkon.Kalaha.models.Pit;
import com.alkon.Kalaha.models.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    public List<Pit> startGame() {
        List<Pit> pits = new ArrayList<>();
        return initializeBoard(pits);
    }

    private List<Pit> initializeBoard(List<Pit> pits) {
        pits.add(0, new Pit(0, 0, "lp2"));
        for (int i = 1; i < 7; i++) {
            pits.add(new Pit(i, 6, "p1"));
        }
        pits.add(7, new Pit(7, 0, "lp1"));
        for (int i = 8; i < 14; i++) {
            pits.add(new Pit(i, 6, "p2"));
        }
        return pits;
    }

    public GameState playTurn(GameState gameState,Game game) {
        game.playersTurn();
        return gameState;
    }
}


