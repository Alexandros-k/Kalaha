package com.alkon.Kalaha.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter @Setter @NoArgsConstructor @Component
public class Board {

    private List<Pit> boardPits;
    private Pit selectedPit;
    private Pit endPit;
    private int rocksSelected;
    private Player player;

    public Board(List<Pit> boardPits, Pit selectedPit, Player player) {
        this.boardPits = boardPits;
        this.selectedPit = selectedPit;
        this.player = player;
        this.rocksSelected = selectedPit.getRocks();
        //this.endPit = findEndPit();
    }

    public void createBoard(GameState gameState, Player player){
        this.boardPits = gameState.getBoardState();
        this.selectedPit = gameState.getPitPicked();
        this.player = player;
        this.rocksSelected = selectedPit.getRocks();
        this.endPit = findEndPit();
    }

    public Pit findEndPit(){
        int rocksSelected = getRocksSelected();
        int startingPoint = selectedPit.getId();
        Pit nextPit= null;
        int counter = 1;
        int counterSP = startingPoint;

        boardPits.get(startingPoint).setRocks(0);//its needed for capturing oppositblocks.
        while (rocksSelected != 0) {
            int nextPitID = counterSP + counter;
            if (nextPitID > 13 && player.getPlayerTag().equals("p1")) {
                nextPitID = 1;
                counterSP = 1;
                counter = 0;
            }else if (nextPitID > 13 && player.getPlayerTag().equals("p2")) {
                nextPitID = 0;
                counterSP = 0;
                counter = 0;
            }
            if (nextPitID ==7 && player.getPlayerTag().equals("p2")){
                nextPitID = 8;
                counterSP = 1;
            }
             nextPit = boardPits.get(nextPitID);
            counter++;
            rocksSelected--;
        }
        return nextPit;
    }
}
