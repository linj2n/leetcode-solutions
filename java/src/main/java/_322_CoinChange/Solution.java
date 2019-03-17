package _322_CoinChange;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        return solution3(coins, amount);
    }
    // Solution1: dfs (TLE)
    // Time: O(2^n), Space: O(n)
    private int dfs(int i, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (i < coins.length && amount > 0) {
            int maxVal = amount / coins[i];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x ++) {
                if (amount >= x * coins[i]) {
                    int resMinCost = dfs(i + 1, coins, amount - x * coins[i]);
                    if (resMinCost != - 1) {
                        minCost = Math.min(minCost, resMinCost + x);
                    }
                }
            }
            return minCost != Integer.MAX_VALUE ? minCost : -1;
        }
        return -1;
    }
    // Solution2: top-Down-DP (AC)
    // Time: O(amount * n), Space: O(amount)
    private int solution2(int i, int[] coins, int amount) {
        // return calc2(0, coins, amount, new int[coins.length + 1][amount + 1]);
        return calc1(coins, amount, new int[amount + 1]);
    }
    private int calc1(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = calc1(coins, amount - coin, dp);
            if (count >= 0 && count < min) {
                min = 1 + count;
            }
        }
        dp[amount] = min != Integer.MAX_VALUE ? min : -1;
        return dp[amount];
    }

    private int calc2(int i, int[] coins, int amount, int[][] dp) {
        int res = Integer.MAX_VALUE;
        if (i == coins.length) {
            res = amount == 0 ? 0 : -1;
        } else {
            for (int k = 0; k * coins[i] <= amount; k ++) {
                int count = dp[i + 1][amount - k * coins[i]];
                if (count == 0) {
                    // 子问题没有求解过，更新 count
                    count = calc2(i + 1, coins, amount - k * coins[i], dp);
                }
                res = count == -1 ? res : Math.min(res, k + count);
            }
        }
        dp[i][amount] = (res == Integer.MAX_VALUE ? -1 : res);
        return dp[i][amount];
    }

    // Solution3: bottom-up DP
    // Time: O(n * amount), Space: O(amount)
    private int solution3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i ++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
