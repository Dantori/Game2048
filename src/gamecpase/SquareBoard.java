package gamecpase;

import java.util.*;

public class SquareBoard extends Board {

    int size;

    public SquareBoard(int size) {
        super(size, size);
        this.size = size;
    }

    @Override
    public void fillBoard(List<Integer> list) {
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
        List<Key> availableKeys = new ArrayList<>();
        for (Map.Entry<Key, Integer> entry : board.entrySet()) {
            if (entry.getValue() == null) {
                availableKeys.add(entry.getKey());
            }
        }
        return availableKeys;
    }

    @Override
    public void addItem(Key key, Integer value) {
        board.put(key, value);
    }

    @Override
    public Key getKey(int i, int j) {
        for (Map.Entry<Key,Integer> entry : board.entrySet()) {
            if (entry.getKey().equals(new Key(i, j))) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public Integer getValue(Key key) {
        return board.get(key);
    }

    @Override
    public List<Key> getColumn(int j) {
        List<Key> keyColumn = new ArrayList<>();
        for (Map.Entry<Key,Integer> entry : board.entrySet()) {
            if (entry.getKey().getJ() == j) {
                keyColumn.add(entry.getKey());
            }
        }
        return keyColumn;
    }

    @Override
    public List<Key> getRow(int i) {
        List<Key> keyRow = new LinkedList<>();
        for (Map.Entry<Key, Integer> entry : board.entrySet()) {
            if (entry.getKey().getI() == i) {
                keyRow.add(entry.getKey());
            }
        }
        return keyRow;
    }

    @Override
    public boolean hasValue(Integer value) {
        for (Map.Entry<Key, Integer> entry : board.entrySet()) {
            if (Objects.equals(entry.getValue(), value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Integer> getValues(List<Key> keys) {
        List<Integer> values = new ArrayList<>();
        for (Key key : keys) {
            values.add(board.get(key));
        }
        return values;
    }

    public List<Integer> getValueRow(int i){
        return getValues(getRow(i));
    }

    public List<Integer> getValueColumn(int j){
        return getValues(getColumn(j));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
