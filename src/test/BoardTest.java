package test;

import gamecpase.Board;
import gamecpase.SquareBoard;

import java.util.List;

import static java.util.Arrays.asList;

public class BoardTest {

    private final static Board board = new SquareBoard(2);

    public static void main(String[] args) {
        var elementsToAdd = asList(1,2,3,null);
        board.fillBoard(elementsToAdd);

        if (board.availableSpace().get(0) != board.getKey(1, 1)) {
            throw new RuntimeException("availableSpace() not work ✕");
        } else {
            System.out.println("availableSpace() works correctly ✓");
        }

        if (!board.getKey(0, 0).equals(board.getKey(0, 0))) {
            throw new RuntimeException("The keys must be same ✕");
        } else {
            System.out.println("The keys are the same ✓");
        }

        if (board.getKey(2, 2) != null) {
            throw new RuntimeException("Not found key must be null ✕");
        } else {
            System.out.println("Key not found is null ✓");
        }

        if (board.getValue(board.getKey(1, 1)) != null) {
            throw new RuntimeException("getValue() not work ✕");
        } else {
            System.out.println("getValue() works correctly ✓");
        }

        if (!board.hasValue(null) || !board.hasValue(3)) {
            throw new RuntimeException("hasValue() not work ✕");
        } else {
            System.out.println("hasValue() works correctly ✓");
        }

        assertEquals(
                board.getColumn(0),
                asList(board.getKey(0,0), board.getKey(1,0))
        );

        assertEquals(
                board.getRow(0),
                asList(board.getKey(0,0), board.getKey(0,1)));

        assertEquals(
                board.getValues(board.getColumn(0)),
                asList(1, 3));


        board.fillBoard(asList(5,6,7,8));
        if (!board.availableSpace().isEmpty()) {
            throw new RuntimeException("availableSpace() not work ✕");
        } else {
            System.out.println("availableSpace() works correctly ✓");
        }
    }

    private static void assertEquals(List<?> list1, List<?> list2) {
        if (!list1.equals(list2)) {
            throw new RuntimeException("List1: " + list1 + " not equals List2: " + list2 + " ✕");
        } else {
            System.out.println("List1: " + list1 + " equals List2: " + list2 + " ✓");
        }
    }
}