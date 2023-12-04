package logic;

import gamecpase.Board;
import gamecpase.Key;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Game2048 implements Game {

    GameHelper gameHelper = new GameHelper();
    Board board;
    Random random = new Random();

    public Game2048(Board board) {
        this.board = board;
    }

    @Override
    public void init() {
        board.fillBoard(new ArrayList<>(asList(2,4,null,16)));
    }

    @Override
    public boolean canMove() {
        return !board.availableSpace().isEmpty();
    }

    @Override
    public void move(Direction direction) {
        switch (direction) {
            case TOP -> {
                for (int i = 0; i < board.weigh; i++) {
                    gameHelper.moveAndMergeEqual(board.getValueColumn(i));
                }
            }
            case BOTTOM -> {
                for (int i = board.weigh; i > 0; i--) {
                    gameHelper.moveAndMergeEqual(board.getValueColumn(i));
                }
            }
            case LEFT -> {
                for (int i = 0; i < board.height; i++) {
                    gameHelper.moveAndMergeEqual(board.getValueRow(i));
                }
            }
            case RIGHT -> {
                for (int i = board.height; i > 0; i--) {
                    gameHelper.moveAndMergeEqual(board.getValueRow(i));
                }
            }
        }
    }

    @Override
    public void addItem() {
        List<Key> spaces = board.availableSpace();
        for (Key currentKey : spaces) {
            board.addItem(currentKey, random.nextInt(16));
        }
    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
