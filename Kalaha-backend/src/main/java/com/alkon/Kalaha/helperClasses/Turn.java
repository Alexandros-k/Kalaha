/*
package com.alkon.Kalaha.helperClasses;

import com.alkon.Kalaha.models.Board;
import com.alkon.Kalaha.models.Pit;
import com.alkon.Kalaha.models.Player;

import java.util.List;

public class Turn {
    Board board;


    public void playersTurn(){
        setStartingPitRocksToZero();
        sowing();
        checkAndSetOpponentsTurn();
        canCaptureOppositePitsRocks(check);
        if (isGameFinished()){gameResolve();}
    }
    private Player findPlayerWithEmptyPits(Player player, Player opponent) {
        return player.findPitsSum(board.getBoardPits())==0?player:opponent;
    }

    public void sowing() {
        int rocksSelected = board.getRocksSelected();
        int startingPoint = selectedPitId;
        int counter = 1;
        int counterSP = startingPoint;

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

            sow(nextPitID);

            counter++;
            rocksSelected--;
        }
    }

    private void sow(int nextPitID) {
        Pit nextPit = board.getBoardPits().get(nextPitID);
        if (!nextPit.getTag().equals(opponent.getPlayerLargePitTag())) {
            nextPit.setRocks(nextPit.getRocks() + 1);
        }
    }

    private void checkAndSetOpponentsTurn() {
        if (!endPit.getTag().equals(player.getPlayerLargePitTag())) {
            gameState.setPlayerTurn(opponent.getPlayerTag());
        }
    }

    public void setStartingPitRocksToZero() {
        board.getBoardPits().get(selectedPitId).setRocks(0);
    }

    public void gameResolve() {
        Player pl = findPlayerWithEmptyPits(player,opponent);
        Player pl2 = pl.getPlayerTag().equals(player.getPlayerTag())? opponent:player;
        int p1TotalPoints = findPlayersPitsTotalPoints(pl.findPitsSum(board.getBoardPits()),pl.getPlayerTag());
        int p2TotalPoints = findPlayersPitsTotalPoints(pl2.findPitsSum(board.getBoardPits()),pl2.getPlayerTag());

        findPlayersLargePitByTag(pl2.getPlayerTag()).setRocks(p2TotalPoints);
        setOpponentSidetoZero(pl2.getPlayerTag(), board);

        Player winner = p1TotalPoints>p2TotalPoints?pl:pl2;
        gameState.setWinner(winner.getPlayerTag());

        gameState.setGameFinished(true);
    }

    private Pit findPlayersLargePitByTag(String playerTag) {
        int largePitId =playerTag.equals(player.getPlayerTag())?player.getPlayerLargePitId():opponent.getPlayerLargePitId();
        return board.getBoardPits().get(largePitId);
    }

    public void canCaptureOppositePitsRocks(Boolean check) {
        if (check) {
            captureOpponentPitRocks(endPit, board, player, selectedPitId);
            gameState.setPlayerTurn(player.getPlayerTag());
        }
    }

    private boolean isGameFinished() {
        int p1Sum = player.findPitsSum(board.getBoardPits());
        int p2Sum = opponent.findPitsSum(board.getBoardPits());
        return p1Sum ==0 || p2Sum ==0?true:false;
    }

    private int findPlayersPitsTotalPoints(int playersPitsSum,String playerTag){
        int playersLPRocks = findPlayersLargePitRocksByTag(playerTag);
        return  playersLPRocks + playersPitsSum;
    }

    private int findPlayersLargePitRocksByTag(String playerTag) {
        int largePitId =playerTag.equals(player.getPlayerTag())?player.getPlayerLargePitId():opponent.getPlayerLargePitId();
        return board.getBoardPits().get(largePitId).getRocks();
    }

    private void setOpponentSidetoZero(String player, Board board) {
        board.getBoardPits().stream().filter(pit -> pit.getTag().equals(player))
                .forEach(pit -> pit.setRocks(0));
    }

    private void captureOpponentPitRocks(Pit endPit, Board board, Player player, int startingPoint) {
        int oppositePitRocks = oppositePitRocks(endPit, board.getBoardPits());
        int LargePitRocks = board.getBoardPits().get(player.getPlayerLargePitId()).getRocks();
        board.getBoardPits().get(player.getPlayerLargePitId()).setRocks(LargePitRocks + 1 + oppositePitRocks);
        board.getBoardPits().get(endPit.getId()).setRocks(0);
        setOppositePitRocksToZero(endPit, board.getBoardPits());
    }

    private int oppositePitRocks(Pit endPit, List<Pit> boardState) {
        int oppositePitId = 14 - endPit.getId();
        int oppositePitRocks = boardState.get(oppositePitId).getRocks();
        return oppositePitRocks;
    }

    private void setOppositePitRocksToZero(Pit endPit, List<Pit> boardState) {
        if (endPit.getId() != 7 && endPit.getId() != 0) {
            int oppositePitId = 14 - endPit.getId();
            boardState.get(oppositePitId).setRocks(0);
        }
    }
}
*/
