package com.alkon.Kalaha.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter @Setter @NoArgsConstructor @Component @Scope("prototype")
public class Player{
    private String playerTag;
    private String playerLargePitTag;
    private int playerLargePitId;

    public Player(String playerTag) {
        this.playerTag = playerTag;
        this.playerLargePitTag = findPlayerLargePitTag();
        this.playerLargePitId = findPlayerLargePitId();
    }
    public void createPlayer(String playerTag){
        this.playerTag = playerTag;
        this.playerLargePitTag = findPlayerLargePitTag();
        this.playerLargePitId = findPlayerLargePitId();
    }

    private String findPlayerLargePitTag(){
        return getPlayerTag().equals("p1")? "lp1":"lp2";
    }
    private int findPlayerLargePitId(){
        return getPlayerTag().equals("p1")? 7:0;
    }
    public int findPitsSum(List<Pit> pits){
       int pitsSum =0;
        for (Pit pit : pits) {
            if (pit.getTag().equals(getPlayerTag())) {
                pitsSum += pit.getRocks();
            }
        }
        return  pitsSum;
    }
    public String findOpponentsTag(){
       return this.playerTag.equals("p1")?"p2":"p1";
    }

    public Player findOpponent(Player player1, Player player2) {
        return this.playerTag.equals(player1.getPlayerTag())?player2:player1;
    }
}
