package com.alkon.Kalaha.controllers;

import com.alkon.Kalaha.models.*;
import com.alkon.Kalaha.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private Player player;
    @Autowired
    private Player opponent;
    @Autowired
    private Game game;
    @Autowired
    private Board board;

    @RequestMapping(value= "/")
    private List<Pit> initializeBoard(){
        return gameService.startGame();
    }

    @PostMapping(value= "/")
    public GameState playerTurn(@RequestBody GameState gameState){
        player.createPlayer(gameState.getPlayerTurn());
        opponent.createPlayer(player.findOpponentsTag());
        board.createBoard(gameState,player);
        game.createGame(gameState,player,opponent,board);
        System.out.println(player+" "+opponent+" "+board+" "+game);
        return gameService.playTurn(gameState,game);
    }
    //TODO Players and game should be created only once and reused
    //TODO Post mapping should return player id and use it to autowire the player
}
