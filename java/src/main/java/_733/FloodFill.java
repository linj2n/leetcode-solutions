package _733;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 1 1 1  -->  2 2 2
 1 1 0       2 2 0
 1 0 1       2 0 2
*/

public class FloodFill {
    private int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
    private int rowLength, colLength;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        this.rowLength = image.length;
        this.colLength = image[0].length;
        dfs(image, sr, sc, newColor);
        return image;
    }

    // DFS
    private void dfs(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return ;
        }
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i ++) {
            int nSr = sr + dRow[i], nSc = sc + dCol[i];
            if (nSr >= 0 && nSr < rowLength && nSc >= 0 && nSc < colLength && image[nSr][nSc] == oldColor) {
                dfs(image, nSr, nSc, newColor);
            }
        }
    }

    // BFS
    private void bfs(int[][]image, int row, int col, int newColor) {
        Deque<Integer> xDeque = new ArrayDeque<>(), yDeque = new ArrayDeque<>();
        xDeque.addLast(row);
        yDeque.addLast(col);
        int oldColor = image[row][col];
        image[row][col] = newColor;
        while (!xDeque.isEmpty()) {
            int x = xDeque.removeFirst(), y = yDeque.removeFirst();
            for (int i = 0; i < 4; i ++) {
                int nRow = x + dRow[i], nCol = y + dCol[i];
                if (nRow >= 0 && nRow < rowLength && nCol >= 0 && nCol < colLength && image[nRow][nCol] == oldColor) {
                    xDeque.addLast(nRow);
                    yDeque.addLast(nCol);
                    image[nRow][nCol] = newColor;
                }
            }
        }
    }
}
