package logic;

import gamecpase.Board;

public interface Game {

    void init();
    boolean canMove();
    boolean move(Direction direction);
    void addItem();
    Board getGameBoard();
    boolean hasWin();
}