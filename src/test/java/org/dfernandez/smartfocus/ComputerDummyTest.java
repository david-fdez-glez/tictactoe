package org.dfernandez.smartfocus;

import org.dfernandez.smartfocus.game.Game;
import org.dfernandez.smartfocus.model.Mark;
import org.dfernandez.smartfocus.util.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComputerDummyTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game(Constants.DUMMY_COMPUTER);
    }

    @Test
    public void computerCanAddMark() {
        assertEquals(9, game.getGameBoard().getFreeSpaces());
        game.computerAddMark();
        assertEquals(8, game.getGameBoard().getFreeSpaces());
    }

    @Test
    public void computerDummyWinGame() {
        game.resetGame();
        game.computerAddMark();
        game.computerAddMark();
        game.computerAddMark();
        assertTrue(game.isGameOver());
        assertEquals(Mark.CROSS, game.getWinner());
    }

    @Test
    public void computerDummyLoseGame() {
        game.resetGame();
        game.computerAddMark();
        game.playerAddMark(7);
        game.computerAddMark();
        game.playerAddMark(8);
        game.computerAddMark();
        game.playerAddMark(9);
        assertTrue(game.isGameOver());
        assertEquals(Mark.NOUGHT, game.getWinner());
    }
}
