package org.dfernandez.smartfocus.game;

import org.dfernandez.smartfocus.model.Board;
import org.dfernandez.smartfocus.model.Mark;
import org.dfernandez.smartfocus.service.Computer;
import org.dfernandez.smartfocus.service.ComputerFactory;


public class Game {

    private Board gameBoard;


    private Computer computer;

    // Flag to check if the Game is Ove
    private boolean gameOver;

    // Winner
    private Mark winner;

    public Game(int typeComputer) {
        gameBoard = new Board();
        computer = ComputerFactory.getComputer(typeComputer, gameBoard);
        gameOver = false;
        winner = Mark.BLANK;

    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public boolean isGameOver() {
        return gameOver;
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


    /**
     * Computer add Mark
     * @return
     */
    public boolean computerAddMark() {
        int bestPosition = computer.getMarkNextPosition();
        if(gameBoard.addMark(bestPosition, Mark.CROSS)) {
            if(gameOver()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the game is finish
     * @return
     */
    private boolean gameOver() {

        if(gameBoard.checkWinningSolution())   {
            this.winner = gameBoard.getWinnerMark();
            this.gameOver = true;
            System.out.println("\n\nGame ended. " + convertWinner(this.winner) + " won.");
        } else if(gameBoard.isFull()) {
            this.gameOver = true;
            this.winner = Mark.BLANK;
            System.out.println("\n\nGame ended Draw")  ;
        }

        return this.gameOver;
    }

    public Mark getWinner() {
           return  this.winner;
    }

    /**
     * For Simplicity, Computer will be always CROSS
     * @param mark
     * @return
     */
    private String convertWinner(Mark mark) {
        switch (mark) {
            case CROSS:
                return "Computer";
            case NOUGHT:
                return "You";
            default:
                return "No one";
        }
    }
}