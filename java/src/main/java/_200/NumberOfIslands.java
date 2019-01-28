package _200;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    count ++;
                    bfs(grid, i, j);
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
                int nX = x + dx[i], nY = y + dy[i];
                if (nX >= 0 && nX < grid.length && nY >= 0 && nY < grid[0].length && grid[nX][nY] == '1') {
                    xDeque.addLast(nX);
                    yDeque.addLast(nY);
                    grid[nX][nY] = '0';
                }
            }
        }
    }
    // DFS
    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        for (int i = 0; i < 4; i ++) {
            int nRow = row + dx[i], nCol = col + dy[i];
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == '1') {
                dfs(grid, nRow, nCol);
            }
        }
    }
}
