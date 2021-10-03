import {Component, OnInit} from '@angular/core';
import {AppServiceService} from "./app-service.service";
import {Pit} from "./Models/Pit";
import {GameState} from "./Models/GameState";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'kalaha-bol';
  boardState: Pit[] = []
  playerTurn: string = "p1"; //TODO playerTurn to be enum p1 or p2
  p1ScoreNumber: number = 0;
  p2ScoreNumber: number = 0;
  isGameFinished: boolean = false;
  winner: string = "";
  constructor(private appServiceService: AppServiceService) {

  }

  ngOnInit() {
    this.setupBoard()
  }

  startGame(playerTurn: string ) {
    this.appServiceService.startGame().subscribe(data => {
      this.boardState = <Pit[]>data;
      this.p1ScoreNumber = 0;
      this.p2ScoreNumber = 0;
      this.playerTurn = "p1";
    })
    if (this.winner != ""){
      this.playerTurn = this.winner;
    }else{
      this.playerTurn = playerTurn;}

  }

  setupBoard() {
    for (let i = 0; i < 14; i++) {
      this.boardState[i] = {id: 0, rocks: 0, tag:""};
    }
  }

  pitSelection(boardStateElement: Pit) {
    let gameState: GameState = {
      playerTurn: this.playerTurn,
      boardState: this.boardState,
      gameFinished: false,
      pitPicked: boardStateElement,
      winner:""
    };
    this.appServiceService.playerTurn(gameState).subscribe(gameState => {
      this.boardState = gameState.boardState;
      this.playerTurn = gameState.playerTurn;
      this.isGameFinished = gameState.gameFinished;
      this.winner = gameState.winner;
      console.log( this.winner)
      console.log( this.isGameFinished)
      if(this.isGameFinished){
        this.gameFinished(this.winner);
        console.log( this.winner +"test")
      }
    });

  }

  gameFinished(winner :string){
    if(winner =="p1"){
      this.p1ScoreNumber++
      console.log( this.p1ScoreNumber)
    }else if(winner =="p2"){
      this.p2ScoreNumber++
      console.log( this.p2ScoreNumber)
    }
    this.setupBoard()
    this.startGame(winner)
  }


}
