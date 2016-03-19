package org.dfernandez.smartfocus.game;

import org.dfernandez.smartfocus.model.Board;
import org.dfernandez.smartfocus.model.Mark;


public class Game {

    private Board gameBoard;

    // flag to check first player to move
    private boolean computerFirst;

    // Flag to check if the Game is Ove
    private boolean gameOver;

    // Var Winner
    private Mark winner;

    public Game() {
        gameBoard = new Board();
        gameOver = false;
        winner = Mark.BLANK;

    }

    public Board getGameBoard() {
        return gameBoard;
    }

    /**
     * Reset Game
     */
    public void resetGame() {
        gameBoard.reset();
        gameOver = false;
        winner = Mark.BLANK;
    }

    /**
     * check if the position on the board is BLANK
     * @param position
     * @return
     */
    public boolean isPositionFree(int position) {
        if(gameBoard.getMarkAtPosition(position) != null) {
              return (gameBoard.getMarkAtPosition(position) == Mark.BLANK);
        }
        return false;
    }

    /**
     * Try to add player Mark
     * @param position
     */
    public boolean playerAddMark(int position) {
           if(gameBoard.addMark(position, Mark.NOUGHT)) {
               if(gameOver()) {
                    return true;
               }
           }
        return false;
    }

    public boolean gameOver() {

        if(gameBoard.checkWinningSolution())   {
            this.winner = gameBoard.getWinningMark();
            this.gameOver = true;
            System.out.println(" Game ended. Player " + this.winner + " won.");
        } else if(gameBoard.isFull()) {
            this.gameOver = true;
            System.out.println(" Game ended Draw")  ;

        }

        return this.gameOver;
    }

    public Mark getWinner() {
           return gameBoard.getWinningMark();
    }
}
