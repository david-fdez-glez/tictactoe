package org.dfernandez.smartfocus;

import org.dfernandez.smartfocus.game.Game;

import org.dfernandez.smartfocus.model.Mark;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class GameTest {

    private Game game;

    private int boardSize;

    @Before
    public void setUp() {
        game = new Game(1);
        boardSize = 9;
    }

    @Test
    public void newGameNoWinner() {
        assertEquals(Mark.BLANK, game.getWinner());
    }

    @Test
    public void newGameNoOver() {
        assertFalse(game.isGameOver());
    }

    @Test
    public void newGameFreeSpaces() {
        for(int i=1;i<=9; i++) {
            assertTrue(game.isPositionFree(i));
        }
    }


    @Test
    public void  playerCanAddMark() {
        assertTrue(game.isPositionFree(2));
        game.playerAddMark(2);
        assertFalse(game.isPositionFree(2));
    }

    @Test
    public void gameReset() {
        game.playerAddMark(9);
        game.resetGame();
        assertTrue(game.isPositionFree(9));

    }


    @Test
    public void playerWin(){
        game.playerAddMark(1);
        game.playerAddMark(5);
        game.playerAddMark(9);
        assertTrue(game.isGameOver());
        assertEquals(Mark.NOUGHT, game.getWinner());

    }
}
