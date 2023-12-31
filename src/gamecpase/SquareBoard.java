package gamecpase;

import java.util.*;

public class SquareBoard<V> extends Board<Key, V> {

    int size;

    public SquareBoard(int size) {
        super(size, size);
        this.size = size;
    }

    @Override
    public void fillBoard(List<V> list) {
        int index = 0;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (index < list.size()) {
                    board.put(new Key(i, j), list.get(index++));
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public List<Key> availableSpace() {
        var availableKeys = new ArrayList<Key>();
        for (Map.Entry<Key, V> entry : board.entrySet()) {
            if (entry.getValue() == null) {
                availableKeys.add(entry.getKey());
            }
        }
        return availableKeys;
    }

    @Override
    public void addItem(Key key, V value) {
        board.put(key, value);
    }

    @Override
    public Key getKey(int i, int j) {
        for (Map.Entry<Key, V> entry : board.entrySet()) {
            if (entry.getKey().equals(new Key(i, j))) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public V getValue(Key key) {
        return board.get(key);
    }

    @Override
    public List<Key> getColumn(int j) {
        var keyColumn = new ArrayList<Key>();
        for (Map.Entry<Key, V> entry : board.entrySet()) {
            if (entry.getKey().getJ() == j) {
                keyColumn.add(entry.getKey());
            }
        }
        return keyColumn;
    }

    @Override
    public List<Key> getRow(int i) {
        var keyRow = new LinkedList<Key>();
        for (Map.Entry<Key, V> entry : board.entrySet()) {
            if (entry.getKey().getI() == i) {
                keyRow.add(entry.getKey());
            }
        }
        return keyRow;
    }

    @Override
    public boolean hasValue(V value) {
        return board.containsValue(value);
    }

    @Override
    public List<V> getValues(List<Key> keys) {
        var values = new ArrayList<V>();
        for (Key key : keys) {
            values.add(board.get(key));
        }
        return values;
    }

    public List<V> getValueRow(int i){
        return getValues(getRow(i));
    }

    public List<V> getValueColumn(int j){
        return getValues(getColumn(j));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
