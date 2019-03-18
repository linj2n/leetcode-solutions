package _279_PerfectSquares;

import java.util.*;

public class Solution {
    public int numSquares(int n) {
        return solution1(n);
    }
    // Solution1: BFS
    private int solution1(int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        while (!deque.isEmpty()) {
            int s = deque.removeFirst();
            if (s == n) {
                return dist[n];
            }
            for (int j = 1; s + j * j <= n; j ++) {
                int temp = s + j * j;
                if (dist[temp] > dist[s] + 1) {
                    dist[temp] = dist[s] + 1;
                    deque.addLast(temp);
                }
            }
        }
        return 0;
    }
    // Solution 2: Top-down DP
    // Time: O(n^2), Space: O(n)
    private int solution2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i ++) {
            nums.add(i * i);
        }
        return dp1(n, dp, nums);
    }
    private int dp1(int n, int[] dp, List<Integer> nums) {
        if (dp[n] != -1) {
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for (int sq : nums) {
            if (n < sq) {
                break;
            }
            int res = dp1(n - sq, dp, nums);
            min = Math.min(min, res + 1);
        }
        dp[n] = min != Integer.MAX_VALUE ? min : n;
        return dp[n];
    }

    // Solution 3: Dynamic programming (Bottom-up, Optimal)
    // Time: O(n^2), Space: O(n)
    private int solution3(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i ++) {
            nums.add(i * i);
        }
        for (int k = 2; k <= n; k ++) {
            dp[k] = Integer.MAX_VALUE;
            for (int s : nums) {
                if (k < s) {
                    break;
                }
                dp[k] = Math.min(dp[k - s] + 1, dp[k]);
            }
        }
        return dp[n];
    }
    // Solution 4: Dynamic programming (Bottom-up)
    private int solution4(int n) {
        if (n == 0) {
            return 0;
        }
        // 0. 计算所有可以使用的平方数
        List<Integer> squareNums = new ArrayList<>();
        for (int num = 1; num <= Math.sqrt(n); num ++) {
            squareNums.add(num * num);
        }
        // 1. dp[i][j], 使用前 i 个平方数构成 j 的最小数量
        int[][] dp = new int[squareNums.size()][n + 1];
        for (int s = 0; s < dp.length; s ++) {
            Arrays.fill(dp[s], Integer.MAX_VALUE);
        }

        // 2. 问题边界状态：dp[0][k] = k, dp[..][0] = 0
        for (int k = 1; k <= n; k ++) {
            dp[0][k * squareNums.get(0)] = k;
        }
        for (int r = 0; r < dp.length; r ++) {
            dp[r][0] = 0;
        }
        // 3. 根据状态转移方程：dp[i][j] = min{dp[i-1][j], dp[i][j - squareNums.get(i)] + 1}
        for (int i = 1; i < dp.length; i ++) {
            for (int j = 1; j <= n; j ++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                int t = (int)(j - squareNums.get(i));
                if (t >= 0 && dp[i][t] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][t] + 1);
                }
            }
        }
        return dp[dp.length - 1][n];
    }

}