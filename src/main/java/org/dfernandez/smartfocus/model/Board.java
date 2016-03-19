package org.dfernandez.smartfocus.model;


public class Board {

    // Number or rows and columns
    public static final int ROWS = 3;
    public static final int COLS = 3;
    // number of empty spaces
    private int blankSpaces;
    // Winning Mark
    private Mark winningMark;

    // game Board
    private Cell[][] gameBoard;

    public Board() {
        gameBoard = new Cell[ROWS][COLS];
        // Init GameBoard
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                gameBoard[row][col] = new Cell();  // clear the cell content
            }
        }

        blankSpaces = ROWS*COLS;
        winningMark = Mark.BLANK;
    }

    /**
     * Reset Gameboard
     */
    public void reset() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                gameBoard[row][col].clear();  // clear the cell content
            }
        }
        blankSpaces = ROWS*COLS;
        winningMark = Mark.BLANK;
    }

    /**
     * Get number of empty positions
     * @return
     */
    public int getFreeSpaces() {
       return this.blankSpaces;
    }

    // Get Winner
    public Mark getWinningMark() {
        return winningMark;
    }

    /**
     * Get Mark at specific position
     * @param position  (1..ROWS*COLS)
     * @return   Mark of null if position it's out of range
     */
    public Mark getMarkAtPosition(int position) {
        if(position <= ROWS*COLS) {
            return gameBoard[(position-1)/3][(position-1)%3].getContent();
        }
        return null;
    }

    /**
     * Add a new Mark to a specific position
     * @param position  (1..ROWS*COLS)
     * @param mark
     */
    public boolean addMark(int position, Mark mark) {
        if((position >0) && (position <= ROWS*COLS)) {
            if(gameBoard[(position-1)/ROWS][(position-1)%COLS].getContent() == Mark.BLANK) {
                gameBoard[(position-1)/ROWS][(position-1)%COLS].setContent(mark);
                blankSpaces--;
                return true;
            }
        }
        return false;
    }

    /**
     * Delete a Mark for a specific position (set to BLANK)
     * @param position
     */
    public void removeMark(int position) {
        if(position <= ROWS*COLS) {
            gameBoard[(position-1)/ROWS][(position-1)%COLS].setContent(Mark.BLANK);
            blankSpaces++;
        }
    }
    /** Return true if there are no more EMPTY cell */
    public boolean isFull() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (gameBoard[row][col].getContent() == Mark.BLANK) {
                    return false; // an empty seed found, exit
                }
            }
        }
        return true; // no empty cell
    }

    /**
     * Check if the game has a winner
     * @return
     */
    public boolean checkWinningSolution() {

        // Check First Mark.NOUGHT
       if(hasWinningSolution(Mark.NOUGHT))  {
           winningMark = Mark.NOUGHT;
           return true;
       }
        if(hasWinningSolution(Mark.CROSS)) {
            winningMark = Mark.CROSS;
            return true;
        }

        return false;

    }

    /**
     * Private Function to check All possible solutions based on a specific Mark
     * @param mark
     * @return
     */
    private boolean hasWinningSolution(Mark mark) {

       // Check Lines
       for(int i=0; i<ROWS;i++) {
            if(gameBoard[i][0].getContent() == mark &&gameBoard[i][1].getContent() == mark && gameBoard[i][2].getContent() == mark ) {
                return true;
            }
       }

        // Check Columns
        for(int j=0; j<COLS;j++) {
            if(gameBoard[0][j].getContent() == mark &&gameBoard[1][j].getContent() == mark && gameBoard[2][j].getContent() == mark ) {
                return true;
            }
        }
        // Check Diagonals
        if(gameBoard[0][0].getContent() == mark &&gameBoard[1][1].getContent() == mark && gameBoard[2][2].getContent() == mark ) {
            return true;
        }
        if(gameBoard[0][2].getContent() == mark &&gameBoard[1][1].getContent() == mark && gameBoard[2][0].getContent() == mark ) {
            return true;
        }

        return false;

    }


    public void paint() {
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col <COLS; col++) {
                gameBoard[row][col].paint();
                if(col < COLS -1) System.out.print(" | ");
            }
            System.out.println();
            if(row < ROWS -1) System.out.println("---------------------");
        }
    }
}
