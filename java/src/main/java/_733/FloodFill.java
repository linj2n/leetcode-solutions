package _733;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 1 1 1  -->  2 2 2
 1 1 0       2 2 0
 1 0 1       2 0 2
*/

public class FloodFill {
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        int height = image.length, width = image[0].length;
        bfs(image, sr, sc, newColor);
        return image;
    }

    // DFS
    private void dfs(int[][] image, int row, int col, int newColor) {
        if (image[row][col] == newColor) {
            return ;
        }
        int oldColor = image[row][col];
        image[row][col] = newColor;
        for (int i = 0; i < 4; i ++) {
            int nRow = row + dx[i], nCol = col + dy[i];
            if (nRow >= 0 && nRow< image.length && nCol >= 0 && nCol < image[0].length && image[nRow][nCol] == oldColor) {
                dfs(image, nRow, nCol, newColor);
            }
        }
    }

    // BFS
    private void bfs(int[][]image, int row, int col, int newColor) {
        if (image[row][col] == newColor) {
            return ;
        }
        Deque<Integer> xDeque = new ArrayDeque<Integer>(), yDeque = new ArrayDeque<Integer>();
        xDeque.addLast(row);
        yDeque.addLast(col);
        int oldColor = image[row][col];
        image[row][col] = newColor;
        while (!xDeque.isEmpty()) {
            int x = xDeque.removeFirst(), y = yDeque.removeFirst();
            for (int i = 0; i < 4; i ++) {
                int nRow = x + dx[i], nCol = y + dy[i];
                if (nRow >= 0 && nRow < image.length && nCol >= 0 && nCol < image[0].length && image[nRow][nCol] == oldColor) {
                    xDeque.addLast(nRow);
                    yDeque.addLast(nCol);
                    image[nRow][nCol] = newColor;
                }
            }
        }
    }
}
