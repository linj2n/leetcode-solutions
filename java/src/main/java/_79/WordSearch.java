package _79;

public class WordSearch {
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (dfs(board, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int sr, int sc, char[] word, int k ) {
        if (board[sr][sc] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        char origin = board[sr][sc];
        board[sr][sc] = '*';
        for (int i = 0; i < 4; i ++) {
            int nextSr = sr + dx[i], nextSc = sc + dy[i];
            if (nextSr >= 0 && nextSr < board.length && nextSc >= 0 && nextSc < board[0].length) {
                if (dfs(board, nextSr, nextSc, word, k + 1)) {
                    return true;
                }
            }
        }
        board[sr][sc] = origin;
        return false;
    }
}
