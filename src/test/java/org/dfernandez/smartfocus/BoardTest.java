package org.dfernandez.smartfocus;

import org.dfernandez.smartfocus.model.Board;

import org.dfernandez.smartfocus.model.Mark;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    private Board gameBoard;

    @Before
    public void setUp() {
        gameBoard = new Board();
    }


    @Test
    public void getFreeSpaces() {
        assertEquals(9, gameBoard.getFreeSpaces());

        gameBoard.addMark(1, Mark.CROSS);
        assertEquals(8, gameBoard.getFreeSpaces()) ;

    }

    @Test
    public void boardAddMark() {
        gameBoard.addMark(9, Mark.NOUGHT);
        assertEquals(8, gameBoard.getFreeSpaces()) ;

    }

    @Test
    public void boardRemoveMark() {
        gameBoard.addMark(8,Mark.CROSS);
        assertTrue(gameBoard.getMarkAtPosition(8) == Mark.CROSS);
        gameBoard.removeMark(8);
        assertFalse(gameBoard.getMarkAtPosition(8) == Mark.CROSS);
        assertTrue(gameBoard.getMarkAtPosition(8) == Mark.BLANK);
        assertEquals(9,gameBoard.getFreeSpaces());
    }


    @Test
    public void boardCheckWinningSolution() {
        gameBoard.addMark(1,Mark.CROSS);
        gameBoard.addMark(2,Mark.CROSS);

        assertFalse(gameBoard.checkWinningSolution());
        gameBoard.addMark(3,Mark.CROSS);
        assertTrue(gameBoard.checkWinningSolution());

    }

    @Test
    public void boardCrossWinning() {
        gameBoard.addMark(3,Mark.CROSS);
        gameBoard.addMark(5,Mark.CROSS);
        gameBoard.addMark(7,Mark.CROSS);
        assertTrue(gameBoard.checkWinningSolution());

        assertEquals(Mark.CROSS, gameBoard.getWinningMark());
    }

    @Test
    public void boardNOUGHTWinning() {
        gameBoard.addMark(4,Mark.NOUGHT);
        gameBoard.addMark(5,Mark.NOUGHT);
        gameBoard.addMark(6,Mark.NOUGHT);
        assertTrue(gameBoard.checkWinningSolution());

        assertEquals(Mark.NOUGHT, gameBoard.getWinningMark());


    }
}
