package org.dfernandez.smartfocus;

import org.dfernandez.smartfocus.game.Game;
import org.dfernandez.smartfocus.model.Mark;
import org.dfernandez.smartfocus.service.Computer;
import org.dfernandez.smartfocus.service.ComputerDummyImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComputerTest {

    private Game game;
    private Computer computer;

    @Before
    public void setUp() {
        game = new Game();
        computer = new ComputerDummyImpl(game.getGameBoard());
    }

    @Test
    public void computerCanAddMark() {
        assertEquals(9, game.getGameBoard().getFreeSpaces());
        game.computerAddMark();
        assertEquals(8, game.getGameBoard().getFreeSpaces());
    }

    @Test
    public void computerDummyWinGame(){
        game.computerAddMark();
        game.computerAddMark();
        game.computerAddMark();
        assertTrue(game.gameOver());
        assertEquals(Mark.CROSS, game.getWinner());
    }
}
