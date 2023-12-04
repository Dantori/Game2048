package gamecpase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Board {

    public int weigh;
    public int height;
    Map<Key, Integer> board = new LinkedHashMap<>();

    protected Board(int weigh, int height) {
        this.weigh = weigh;
        this.height = height;
    }

    /**
     * Fills the board with values from the list
     *
     * @param list the list of values to fill the board with
     */
    public abstract void fillBoard(List<Integer> list);

    /**
     * @return a list of available keys on the board
     */
    public abstract List<Key> availableSpace();


    /**
     * Adds an item to the specified key.
     *
     * @param key the key to add the item to
     * @param value the value to add to the specified key
     */
    public abstract void addItem(Key key, Integer value);

    /**
     * Returns the key for the given coordinates.
     *
     * @param i the coordinate i
     * @param j the coordinate j
     * @return the key for the given coordinates
     */
    public abstract Key getKey(int i, int j);

    /**
     * Returns the value for the specified key.
     *
     * @param key the key to retrieve the value for
     * @return the value corresponding to the specified key
     */
    public abstract Integer getValue(Key key);

    /**
     * Returns a list of keys for the specified column.
     *
     * @param j the column number
     * @return a list of keys for the specified column
     */
    public abstract List<Key> getColumn(int j);

    /**
     * Returns a list of keys for the specified row.
     *
     * @param i the row number
     * @return a list of keys for the specified row
     */
    public abstract List<Key> getRow(int i);

    /**
     * Checks for the presence of a value on the board.
     *
     * @param value the value to check for presence on the board
     * @return true if the value is present on the board, false otherwise
     */
    public abstract boolean hasValue(Integer value);

    /**
     * Returns a list of values for the specified keys.
     *
     * @param keys the list of keys to retrieve the values for
     * @return a list of values for the specified keys
     */
    public abstract List<Integer> getValues(List<Key> keys);

    /**
     * Returns a list of values for the specified row.
     *
     * @param i the row number
     * @return a list of values for the specified row
     */
    public abstract List<Integer> getValueRow(int i);

    /**
     * Returns a list of values for the specified column.
     *
     * @param j the column number
     * @return a list of values for the specified column
     */
    public abstract List<Integer> getValueColumn(int j);
}
