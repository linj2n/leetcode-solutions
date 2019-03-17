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
        return coinChange(coins, amount, new int[amount + 1]);
    }
    private int coinChange(int[] coins, int amount, int[] dp) {
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
            int count = coinChange(coins, amount - coin, dp);
            if (count >= 0 && count < min) {
                min = 1 + count;
            }
        }
        dp[amount] = min != Integer.MAX_VALUE ? min : -1;
        return dp[amount];
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
