package com.alkon.Kalaha.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class GameState {
    private String playerTurn;
    private List<Pit> boardState;
    private Boolean gameFinished;
    private Pit pitPicked;
    private String winner;
}
