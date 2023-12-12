package gamecpase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Board<K, V> {

    public int weigh;
    public int height;
    Map<K, V> board = new LinkedHashMap<>();

    protected Board(int weigh, int height) {
        this.weigh = weigh;
        this.height = height;
    }

    /**
     * Fills the board with values from the list
     *
     * @param list the list of values to fill the board with
     */
    public abstract void fillBoard(List<V> list);

    /**
     * @return a list of available keys on the board
     */
    public abstract List<K> availableSpace();


    /**
     * Adds an item to the specified key.
     *
     * @param key the key to add the item to
     * @param value the value to add to the specified key
     */
    public abstract void addItem(K key, V value);

    /**
     * Returns the key for the given coordinates.
     *
     * @param i the coordinate i
     * @param j the coordinate j
     * @return the key for the given coordinates
     */
    public abstract K getKey(int i, int j);

    /**
     * Returns the value for the specified key.
     *
     * @param key the key to retrieve the value for
     * @return the value corresponding to the specified key
     */
    public abstract V getValue(K key);

    /**
     * Returns a list of keys for the specified column.
     *
     * @param j the column number
     * @return a list of keys for the specified column
     */
    public abstract List<K> getColumn(int j);

    /**
     * Returns a list of keys for the specified row.
     *
     * @param i the row number
     * @return a list of keys for the specified row
     */
    public abstract List<K> getRow(int i);

    /**
     * Checks for the presence of a value on the board.
     *
     * @param value the value to check for presence on the board
     * @return true if the value is present on the board, false otherwise
     */
    public abstract boolean hasValue(V value);

    /**
     * Returns a list of values for the specified keys.
     *
     * @param keys the list of keys to retrieve the values for
     * @return a list of values for the specified keys
     */
    public abstract List<V> getValues(List<K> keys);

    /**
     * Returns a list of values for the specified row.
     *
     * @param i the row number
     * @return a list of values for the specified row
     */
    public abstract List<V> getValueRow(int i);

    /**
     * Returns a list of values for the specified column.
     *
     * @param j the column number
     * @return a list of values for the specified column
     */
    public abstract List<V> getValueColumn(int j);
}
