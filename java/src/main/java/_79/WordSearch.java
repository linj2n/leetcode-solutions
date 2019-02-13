package _79;

public class WordSearch {
    private int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
    private int rowLength, colLength;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        this.rowLength = board.length;
        this.colLength = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < rowLength; i ++) {
            for (int j = 0; j < colLength; j ++) {
                if (dfs(board, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int sr, int sc, char[] chars, int k) {
        if (chars[k] != board[sr][sc]) {
            return false;
        }
        if (k == chars.length - 1) {
            return true;
        }
        char origin = board[sr][sc];
        board[sr][sc] = '*';
        for (int i = 0; i < 4; i ++) {
            int nSr = sr + dRow[i], nSc = sc + dCol[i];
            if (nSr >= 0 && nSr < rowLength && nSc >= 0 && nSc < colLength) {
                if (dfs(board, nSr, nSc, chars, k + 1)) {
                    return true;
                };
            }
        }
        board[sr][sc] = origin;
        return false;
    }
}
