package _64_MinimumPathSum;

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rowLen = grid.length, colLen = grid[0].length;
        int[][] dp = new int[rowLen][colLen];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < colLen; i ++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < rowLen; j ++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        for (int sr = 1; sr < rowLen; sr ++) {
            for (int sc = 1; sc < colLen; sc ++) {
                dp[sr][sc] = Math.min(dp[sr - 1][sc] + grid[sr][sc], dp[sr][sc - 1] + grid[sr][sc]);
            }
        }
        return dp[rowLen - 1][colLen - 1];
    }
}
