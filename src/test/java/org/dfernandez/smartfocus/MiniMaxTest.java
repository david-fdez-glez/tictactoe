package org.dfernandez.smartfocus;

import org.dfernandez.smartfocus.model.Board;

import org.dfernandez.smartfocus.model.Mark;
import org.dfernandez.smartfocus.util.MiniMax;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MiniMaxTest {


    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }


    @Test
    public void scoreHighOnWinningMove() {
        board.addMark(1, Mark.CROSS);
        board.addMark(5, Mark.NOUGHT);
        board.addMark(4, Mark.CROSS);
        board.addMark(8, Mark.NOUGHT);
        board.addMark(7, Mark.CROSS);

        assertEquals(10, MiniMax.minimax(board, Mark.CROSS));

    }

    @Test
    public void scoreZeroOnDraw() {
        board.addMark(1, Mark.CROSS);
        board.addMark(5, Mark.NOUGHT);
        board.addMark(7, Mark.CROSS);
        board.addMark(4, Mark.NOUGHT);
        board.addMark(6, Mark.CROSS);
        board.addMark(2, Mark.NOUGHT);
        board.addMark(8, Mark.CROSS);
        board.addMark(9, Mark.NOUGHT);
        board.addMark(3, Mark.CROSS);

        assertEquals(0, MiniMax.minimax(board, Mark.CROSS));

    }


    @Test
    public void scoreLowOnLosingMove() {
        board.addMark(1, Mark.NOUGHT);
        board.addMark(5, Mark.CROSS);
        board.addMark(3, Mark.NOUGHT);
        board.addMark(1, Mark.CROSS);

        assertEquals(-10, MiniMax.minimax(board, Mark.NOUGHT));
    }

}
