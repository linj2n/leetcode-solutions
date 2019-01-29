package _54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int height = matrix.length, width = matrix[0].length;
        boolean[][] isVisited = new boolean[height][width];
        for (int i = 0; i < height && i < width && !isVisited[i][i]; i ++) {
            int sr = i, sc = i;
            list.add(matrix[sr][sc]);
            isVisited[sr][sc] = true;
            for (int t = 0; t < 4; t ++) {
                int nSr = sr + dx[t], nSc = sc + dy[t];
                while (nSr >= 0 && nSr < height && nSc >= 0 && nSc < width && !isVisited[nSr][nSc]) {
                    sr = nSr;
                    sc = nSc;
                    list.add(matrix[sr][sc]);
                    isVisited[sr][sc] = true;
                    nSr += dx[t];
                    nSc += dy[t];
                }
            }
        }
        return list;
    }
}
