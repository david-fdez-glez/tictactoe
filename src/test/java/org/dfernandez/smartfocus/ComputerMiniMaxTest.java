package org.dfernandez.smartfocus;

import org.dfernandez.smartfocus.game.Game;
import org.dfernandez.smartfocus.model.Mark;
import org.dfernandez.smartfocus.util.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComputerMiniMaxTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game(Constants.MINIMAX_COMPUTER);
    }

    @Test
    public void computerCanAddMark() {
        assertEquals(9, game.getGameBoard().getFreeSpaces());
        game.computerAddMark();
        assertEquals(8, game.getGameBoard().getFreeSpaces());
        game.resetGame();
    }

    @Test
    public void computerMiniMaxWinGame() {
        game.resetGame();
        game.computerAddMark();
        game.playerAddMark(9);
        game.computerAddMark();
        game.playerAddMark(8);
        game.computerAddMark();
        assertTrue(game.isGameOver());
        assertEquals(Mark.CROSS, game.getWinner());
    }

    @Test
    public void computerMiniDrawGame() {
        game.resetGame();
        game.computerAddMark();
        game.playerAddMark(5);
        game.computerAddMark();
        game.playerAddMark(3);
        game.computerAddMark();
        game.playerAddMark(4);
        game.computerAddMark();
        game.playerAddMark(8);
        game.computerAddMark();
        assertTrue(game.isGameOver());
        assertEquals(Mark.BLANK, game.getWinner());
    }
}
