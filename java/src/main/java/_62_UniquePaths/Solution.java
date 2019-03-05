package _62_UniquePaths;

public class Solution {
    private int[] dx = {0, 1}, dy = {1, 0};
    private int count = 0;
    public int uniquePaths(int m, int n) {
        return solution2(m, n);
    }

    // DFS (TLE)
    // time: O(2^(nm)), space: O(nm)
    private int solution1(int m, int n) {
        boolean[][] matrix = new boolean[n][m];
        dfs(matrix, 0, 0);
        return count;
    }
    private void dfs(boolean[][] matrix, int sr, int sc) {
        if (sr == matrix.length - 1 && sc == matrix[0].length - 1) {
            count ++;
            return ;
        }
        for (int k = 0; k < 2; k ++) {
            int nSr = sr + dx[k], nSc = sc + dy[k];
            if (nSr >= 0 && nSr < matrix.length && nSc >= 0 && nSc < matrix[0].length) {
                dfs(matrix, nSr, nSc);
            }
        }
    }

    // DP (AC)
    // time: O(n^2), space: O(nm)
    private int solution2(int m, int n) {
        int[][] dp = new int[m][n];
        int rowLen = dp.length, colLen = dp[0].length;
        for (int i = 0; i < colLen; i ++) {
            dp[0][i] = 1;
        }
        for (int j = 0; j < rowLen; j ++) {
            dp[j][0] = 1;
        }
        for (int sr = 1; sr < rowLen; sr ++) {
            for (int sc = 1; sc < colLen; sc ++) {
                dp[sr][sc] = dp[sr - 1][sc] + dp[sr][sc - 1];
            }
        }
        return dp[rowLen - 1][colLen - 1];
    }
}
