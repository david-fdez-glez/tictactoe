package org.dfernandez.smartfocus.service;

import org.dfernandez.smartfocus.model.Board;
import org.dfernandez.smartfocus.model.Mark;
import org.dfernandez.smartfocus.util.MiniMax;


public class ComputerMiniMaxImpl implements Computer {

    private Board gameBoard;


    public ComputerMiniMaxImpl(Board board) {
        gameBoard = board;
    }
    @Override
    public int getMarkNextPosition() {

        int score = 0;
        int[] availableSpaces = gameBoard.getAvailableSpaces();
        int bestIndex = 0;

        if ( gameBoard.checkWinningSolution() )
            score = ((gameBoard.getWinnerMark() == Mark.CROSS) ? 10 : -10);
        else if ( availableSpaces.length != 0 ) {
            for ( int availableIndex = 0; availableIndex < availableSpaces.length && score != 1; availableIndex++ ) {
                int nextScore = getChildBoardScore( availableSpaces[availableIndex] );

                if ( nextScore > score || availableIndex == 0 ) {
                    score = nextScore;
                    bestIndex = availableSpaces[availableIndex];
                }
            }
        }

        return bestIndex;
    }

    private int getChildBoardScore( int spaceIndex ) {
        gameBoard.addMark( spaceIndex, Mark.CROSS );
        int childScore = MiniMax.minimax(gameBoard, Mark.NOUGHT);
        gameBoard.removeMark( spaceIndex );

        return childScore;
    }
}
