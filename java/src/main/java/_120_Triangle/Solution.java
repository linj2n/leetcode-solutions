package _120_Triangle;

import java.util.List;

public class Solution {
    /* Note:
     * 对于某个数 [i][j] 下一行相邻的点的索引为 [i + 1][j] 与 [i + 1][j + 1]
     * 自底向上考虑，问题看做从最后一行任意一点出发，求到第一行的第一个点的最短路径和。
     * 设 dp[i][j] 为到该点的最短路径和，[i][j] 上一个点是：[i + 1][j] 或 [i + 1][j + 1]
     * 易得状态转移方程为： dp[i][j] = [i][j] + min([i + 1][j], [i + 1][j + 1]);
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int rowLen = triangle.size(), colLen = triangle.get(rowLen - 1).size();
        int[][] dp = new int[rowLen][colLen];
        for (int i = 0; i < triangle.size(); i ++) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
                dp[i][j] = triangle.get(i).get(j);
            }
        }
        for (int sr = rowLen - 2; sr >= 0; sr --) {
            for (int sc = 0; sc < triangle.get(sr).size(); sc ++) {
                dp[sr][sc] += Math.min(dp[sr + 1][sc], dp[sr + 1][sc + 1]);
            }
        }
        return dp[0][0];
    }
}
