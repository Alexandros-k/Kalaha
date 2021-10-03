import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {GameState} from "./Models/GameState";

class Pit {
}

@Injectable({
  providedIn: 'root'
})
export class AppServiceService {

  readonly APP_URL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  startGame(){return this.http.get<Pit[]>(this.APP_URL);}

  playerTurn(gameState: GameState) {return this.http.post<GameState>(this.APP_URL, gameState);}
}
