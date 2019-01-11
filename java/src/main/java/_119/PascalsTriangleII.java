package _119;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++ i) {
            for (int j = row.size() - 1; j > 0; -- j) {
                row.set(j,row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }
}
