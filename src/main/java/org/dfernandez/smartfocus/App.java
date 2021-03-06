package org.dfernandez.smartfocus;

import org.dfernandez.smartfocus.game.Game;
import org.dfernandez.smartfocus.util.Constants;
import java.util.Scanner;


public class App 
{

    public static void main( String[] args )
    {
        // flag to check if it is computer turn
        boolean computerTurn;
        String nextPlayer; // next player name

        // Flag to check if the Game is Over
        boolean gameOver;
        // 1 = Dummy, 2 = MiniMax Computer
        Game game = new Game(Constants.MINIMAX_COMPUTER);

        System.out.println("    Welcome to Tic Tac Toe Challenge!" );
        System.out.println("\n This is the Board\n");
        System.out.println("   1   |   2   |   3  ");
        System.out.println("-----------------------");
        System.out.println("   4   |   5   |   6  ");
        System.out.println("-----------------------");
        System.out.println("   7   |   8   |   9  ");
        System.out.println("-----------------------\n");
        System.out.println("Who will start playing? (Any character will exit)");
        System.out.println("1) Computer (X) " );
        System.out.println("2) You (O)");

        Scanner in = new Scanner(System.in);
        int entry;
        // Character enter by the Human Player
        int position;
        // Flag to check if the position is inside board range
        boolean flagPosition = false;
        // Turn number
        int turn = 0;


        while (in.hasNextInt()) {
            game.resetGame();
            gameOver = false;
            flagPosition = false;
            computerTurn = false;
            nextPlayer = "";
            turn = 0;

            entry = in.nextInt();

            switch (entry) {

                case 1:
                    nextPlayer = "Computer";
                    computerTurn = true;
                    break;
                case 2:
                    nextPlayer = "You";
                    computerTurn = false;
                    break;
                default:
                    nextPlayer = "You";
                    computerTurn = false;
                    break;
            }

            do {

                System.out.println("\n\nNext turn: " + nextPlayer);
                flagPosition = false;
                if(computerTurn) {
                    if(game.computerAddMark()) {
                        gameOver = true;
                    }
                    nextPlayer = "You";
                    computerTurn = false;
                 } else {
                    do{
                        System.out.print("Introduce position (1..9). Must be a digit\n");
                        position = 0;
                        while(!in.hasNextInt()) {
                            String aux = in.nextLine();
                        }
                        position = in.nextInt();

                        if((position >=1) && (position <= 9))  {
                            flagPosition = true;
                        }  else {
                            System.out.println("Invalid Position. Type a number between [1..9]");
                        }

                        if(!game.isPositionFree(position) && flagPosition) {
                            System.out.println("Position is not empty. Try another one");

                        }
                    }while(!flagPosition || !game.isPositionFree(position));
                    nextPlayer = "Computer";
                    computerTurn = true;
                    if(game.playerAddMark(position)) {
                        gameOver = true;
                    }
                }
                System.out.println("\n");
                game.getGameBoard().paint();
                turn++;
          } while(!gameOver );
                System.out.println("\n\n");
                System.out.println("Who will start playing? (Any character will exit)");
                System.out.println("1) Computer (X)");
                System.out.println("2) You (O)");
        }
    }
}