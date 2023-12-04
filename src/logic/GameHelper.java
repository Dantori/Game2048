package logic;

import java.util.ArrayList;
import java.util.List;

public class GameHelper {

    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        var result = new ArrayList<Integer>();

        if (list.isEmpty()) {
            return result;
        }

        var tempList = new ArrayList<Integer>();
        for (Integer num : list) {
            if (num != null && num != 0) {
                tempList.add(num);
            }
        }

        int i = 0;
        while (i < tempList.size() - 1) {
            if (tempList.get(i) != null && tempList.get(i).equals(tempList.get(i + 1))) {
                tempList.set(i, tempList.get(i) * 2);
                tempList.remove(i + 1);
                tempList.add(null);
            }
            i++;
        }

        for (int j = 0; j < list.size(); j++) {
            if (j < tempList.size()) {
                result.add(tempList.get(j));
            } else {
                result.add(null);
            }
        }

        return result;
    }
}
