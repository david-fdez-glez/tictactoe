package org.dfernandez.smartfocus.util;


import org.dfernandez.smartfocus.model.Board;
import org.dfernandez.smartfocus.model.Mark;

public class MiniMax {

    public static int minimax(Board board, Mark mark) {
        int score = 0;

        int[] availableSpaces = board.getAvailableSpaces();

        if(board.checkWinningSolution()) {
            score = (board.getWinnerMark() == Mark.CROSS) ? 10 : -10;
        }  else if (availableSpaces.length != 0){
            Mark nextMark = (mark == Mark.CROSS) ? Mark.NOUGHT : Mark.CROSS;
            int bestValue = (mark == Mark.CROSS) ? 10 : -10;

            for(int index = 0; index < availableSpaces.length && score != bestValue; index++) {
                board.addMark(availableSpaces[index],mark);
                int nextScore = minimax(board, nextMark);
                board.removeMark(availableSpaces[index]);

                if(mark == Mark.CROSS && nextScore > score
                 || mark == Mark.NOUGHT && nextScore <score
                 || index == 0) {
                    score = nextScore;
                }
            }
        }

        return score;
    }
}
