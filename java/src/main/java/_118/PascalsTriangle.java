package _118;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 1; i <= numRows; ++ i) {
            List<Integer> row = new ArrayList<>(i);
            row.add(1);
            if (!rows.isEmpty()) {
                List<Integer> preRow = rows.get(rows.size() - 1);
                for (int j = 0; j < preRow.size() - 1; ++ j) {
                    row.add(preRow.get(j) + preRow.get(j + 1));
                }
                row.add(1);
            }
            rows.add(row);
        }
        return rows;
    }
}
