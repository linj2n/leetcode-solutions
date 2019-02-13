package _200;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands {
    private int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
    private int rowLength, colLength;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        rowLength = grid.length;
        colLength = grid[0].length;
        int count = 0;
        for (int i = 0; i < rowLength; i ++) {
            for (int j = 0; j < colLength; j ++) {
                if (grid[i][j] == '1') {
                    count ++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    // BFS
    private void bfs(char[][] grid, int row, int col) {
        Deque<Integer> xDeque = new ArrayDeque<>(), yDeque = new ArrayDeque<>();
        xDeque.addLast(row);
        yDeque.addLast(col);
        grid[row][col] = '0';
        while (!xDeque.isEmpty()) {
            int x = xDeque.removeFirst();
            int y = yDeque.removeFirst();
            for (int i = 0; i < 4; i ++) {
                int nX = x + dRow[i], nY = y + dCol[i];
                if (nX >= 0 && nX < rowLength && nY >= 0 && nY < colLength && grid[nX][nY] == '1') {
                    xDeque.addLast(nX);
                    yDeque.addLast(nY);
                    grid[nX][nY] = '0';
                }
            }
        }
    }
    // DFS
    private void dfs(char[][] grid, int sr, int sc) {
        grid[sr][sc] = '0';
        for (int i = 0; i < 4; i ++) {
            int nSr = sr + dRow[i], nSc = sc + dCol[i];
            if (nSr >= 0 && nSr < rowLength && nSc >= 0 && nSc < colLength && grid[nSr][nSc] == '1') {
                dfs(grid, nSr, nSc);
            }
        }
    }
}
