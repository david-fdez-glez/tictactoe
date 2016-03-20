package org.dfernandez.smartfocus.service;


import org.dfernandez.smartfocus.model.Board;
import org.dfernandez.smartfocus.util.Constants;

public class ComputerFactory {

    public static Computer getComputer(int type, Board board) {

        switch (type) {
            case Constants.DUMMY_COMPUTER: // dummy
                return new ComputerDummyImpl(board) ;
            case Constants.MINIMAX_COMPUTER: //MiniMax
                return new ComputerMiniMaxImpl(board);
            default:
                return new ComputerDummyImpl(board);
        }

    }
}
