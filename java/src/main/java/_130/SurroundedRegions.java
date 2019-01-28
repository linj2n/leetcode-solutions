package _130;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SurroundedRegions {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return ;
        }
        helper(board);
    }

    private void helper(char[][] board) {
        boolean[][] notCaptured = new boolean[board.length][board[0].length];
        List<Integer> xList = new ArrayList<>(), yList = new ArrayList<>();
        int height = board.length, width = board[0].length;
        for (int i = 0; i < height; i ++) {
            if (board[i][0] == 'O') {
                xList.add(i);
                yList.add(0);
                notCaptured[i][0] = true;
            }
            if (board[i][width - 1] == 'O') {
                xList.add(i);
                yList.add(width - 1);
                notCaptured[i][width - 1] = true;
            }
        }
        for (int j = 1; j < width; j ++) {
            if (board[0][j] == 'O') {
                xList.add(0);
                yList.add(j);
                notCaptured[0][j] = true;
            }
            if (board[height - 1][j] == 'O') {
                xList.add(height - 1);
                yList.add(j);
                notCaptured[height - 1][j] = true;
            }
        }
        // System.out.println(xList.size() + ", " + yList.size());
        for (int k = 0; k < xList.size(); k ++) {
            bfs(board, notCaptured, xList.get(k), yList.get(k));
        }
        for (int sr = 0; sr < height; sr ++) {
            for (int sc = 0; sc < width; sc ++) {
                if (!notCaptured[sr][sc]) {
                    board[sr][sc] = 'X';
                }
            }
        }
    }

    // DFS
    private void dfs(char[][] board, boolean[][] notCaptured, int row, int col) {
        notCaptured[row][col] = true;
        for (int i = 0; i < 4; i ++) {
            int nRow = row + dx[i], nCol = col + dy[i];
            if (nRow >= 0 && nRow < board.length && nCol >= 0 && nCol < board[0].length && !notCaptured[nRow][nCol] && board[nRow][nCol] == 'O') {
                dfs(board, notCaptured, nRow, nCol);
            }
        }
    }

    // BFS
    private void bfs(char[][] board, boolean[][] notCaptured, int row, int col) {
        notCaptured[row][col] = true;
        Deque<Integer> xDeque = new ArrayDeque<>(), yDeque = new ArrayDeque<>();
        xDeque.addLast(row);
        yDeque.addLast(col);
        while (!xDeque.isEmpty()) {
            int x = xDeque.removeFirst(), y = yDeque.removeFirst();
            for (int i = 0; i < 4; i ++) {
                int nRow = x + dx[i], nCol = y + dy[i];
                if (nRow >= 0 && nRow < board.length && nCol >= 0 && nCol < board[0].length && !notCaptured[nRow][nCol] && board[nRow][nCol] == 'O') {
                    xDeque.addLast(nRow);
                    yDeque.addLast(nCol);
                    notCaptured[nRow][nCol] = true;
                }
            }
        }
    }
}
