package _130;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SurroundedRegions {
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return ;
        }
        int height = board.length, width = board[0].length;
        boolean[][] notCaptured = new boolean[height][width];
        List<Integer> xList = new ArrayList<>(2 * (height + width)), yList = new ArrayList<>(2 * (height + width));
        for (int i = 0; i < height; i ++) {
            if (board[i][0] == 'O') {
                xList.add(i);
                yList.add(0);
            }
            if (board[i][width - 1] == 'O') {
                xList.add(i);
                yList.add(width - 1);
            }
        }
        for (int j = 1; j < width - 1; j ++) {
            if (board[0][j] == 'O') {
                xList.add(0);
                yList.add(j);
            }
            if (board[height - 1][j] == 'O') {
                xList.add(height - 1);
                yList.add(j);
            }
        }
        for (int k = 0; k < xList.size(); k ++) {
            dfs(board, notCaptured, xList.get(k), yList.get(k));
        }
        for (int x = 0; x < height; x ++) {
            for (int y = 0; y < width; y ++) {
                if (!notCaptured[x][y] && board[x][y] == 'O') {
                    board[x][y] = 'X';
                }
            }
        }
    }
    // DFS
    private void dfs(char[][] board, boolean[][] notCaptured, int sr, int sc) {
        notCaptured[sr][sc] = true;
        for (int i = 0; i < 4; i ++) {
            int row = sr + dx[i], col = sc + dy[i];
            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !notCaptured[row][col] && board[row][col] == 'O') {
                dfs(board, notCaptured, row, col);
            }
        }
    }
    // BFS
    private void bfs(char[][] board, boolean[][] notCaptured, int sr, int sc) {
        notCaptured[sr][sc] = true;
        Deque<Integer> xDeque = new ArrayDeque<>(), yDeque = new ArrayDeque<>();
        xDeque.addLast(sr);
        yDeque.addLast(sc);
        while (!xDeque.isEmpty()) {
            int x = xDeque.removeFirst(), y = yDeque.removeFirst();
            for (int i = 0; i < 4; i ++) {
                int row = x + dx[i], col = y + dy[i];
                if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !notCaptured[row][col] && board[row][col] == 'O') {
                    xDeque.addLast(row);
                    yDeque.addLast(col);
                    notCaptured[row][col] = true;
                }
            }
        }
    }
}
