package _118;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            return null;
        }
        List<List<Integer>> rows = new ArrayList<>(numRows);
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i ++) {
            if (!rows.isEmpty()) {
                for (int j = row.size() - 1; j > 0; -- j) {
                    row.set(j,row.get(j) + row.get(j - 1));
                }
            }
            row.add(1);
            rows.add(new ArrayList<>(row));
        }
        return rows;
    }
}
