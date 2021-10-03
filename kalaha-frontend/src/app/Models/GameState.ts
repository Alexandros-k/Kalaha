import {Pit} from "./Pit";

export  interface GameState{
   playerTurn: string;
   boardState: Pit[];
   gameFinished: boolean;
   pitPicked: Pit;
   winner: string;
}
