package _54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    public List<Integer> spiralOrder(int[][] matrix) {
        return solution1(matrix);
    }
    private List<Integer> solution1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int height = matrix.length, width = matrix[0].length;
        boolean[][] isVisited = new boolean[height][width];
        for (int i = 0; i < height && i < width && !isVisited[i][i]; i ++) {
            int x = i, y = i;
            list.add(matrix[x][y]);
            isVisited[x][y] = true;
            for (int t = 0; t < 4; t ++) {
                int nx = x + dx[t], ny = y + dy[t];
                while (nx >= 0 && nx < height && ny >= 0 && ny < width && !isVisited[nx][ny]) {
                    x = nx;
                    y = ny;
                    list.add(matrix[x][y]);
                    isVisited[x][y] = true;
                    nx += dx[t];
                    ny += dy[t];
                }
            }
        }
        return list;
    }
    private List<Integer> solution2(int[][] matrix) {
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int height = matrix.length, width = matrix[0].length;
        boolean[][] isVisited = new boolean[height][width];
        int x = 0, y = 0, d = 0;
        int nextX = 0, nextY = 0;
        for (int i = 0; i < height * width; i ++) {

            list.add(matrix[x][y]);
            isVisited[x][y] = true;

            nextX = x + dx[d];
            nextY = y + dy[d];
            if (nextX < 0 || nextX >= height || nextY < 0 || nextY >= width || isVisited[nextX][nextY]) {
                d = (d + 1) % 4;
                nextX = x + dx[d];
                nextY = y + dy[d];
            }
            x = nextX;
            y = nextY;
        }
        return list;
    }
}
