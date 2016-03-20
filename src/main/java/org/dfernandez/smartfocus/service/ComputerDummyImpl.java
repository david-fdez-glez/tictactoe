package org.dfernandez.smartfocus.service;

import org.dfernandez.smartfocus.model.Board;
import org.dfernandez.smartfocus.model.Mark;


public class ComputerDummyImpl implements Computer {

    private Board gameBoard;

    public ComputerDummyImpl(Board board) {
        gameBoard = board;
    }


    @Override
    public int getMarkNextPosition() {

        // Just find the first empty place
        for (int i = 1; i <= Board.ROWS*Board.COLS; ++i) {
            if(gameBoard.getMarkAtPosition(i) == Mark.BLANK)
                return i;

        }
        return 0;
    }
}