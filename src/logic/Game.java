package logic;

import gamecpase.Board;

public interface Game {

    /**
     * Initializes the game board with initial values.
     */
    void init();

    /**
     * Determines if a move can be made in the game.
     * @return true if there is available space on the board, false otherwise
     */
    boolean canMove();

    /**
     * Performs a move in the specified direction.
     * @param direction the direction of the move
     */
    void move(Direction direction);

    /**
     * Adds an item to the game board.
     */
    void addItem();

    /**
     * Gets the game board.
     * @return the game board
     */
    Board getGameBoard();

    /**
     * Checks if the game has been won (the value 2048 is present on the board).
     * @return true if the value 2048 is present on the board, false otherwise
     */
    boolean hasWin();
}