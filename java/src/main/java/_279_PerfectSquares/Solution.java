package _279_PerfectSquares;

import java.util.*;

public class Solution {
    public int numSquares(int n) {
        return solution1(n);
    }
    // Solution1: BFS
    private int solution1(int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);   // dist 数组表示所有的点到 0 的距离，初始值为 MAX_VALUE，表示无穷大
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

    // Solution 3: Bottom-up DP
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
}