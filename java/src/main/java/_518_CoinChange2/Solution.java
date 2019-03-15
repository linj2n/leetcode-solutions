package _518_CoinChange2;

public class Solution {
    public int change(int amount, int[] coins) {
        return solution4(amount, coins);
    }

    // Solution 1: Brute force (Time Limit Exceeded)
    public int solution1(int amount, int[] coins) {
        if (coins == null || amount < 0) {
            return 0;
        }
        return calc(amount, 0, coins);
    }
    private int calc(int amount, int index, int[] coins ) {
        if (index == coins.length) {
            return amount == 0 ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; coins[index] * i <= amount; i ++) {
            res += calc(amount - coins[index] * i, index + 1, coins);
        }
        return res;
    }

    // Solution 2: Memoization
    // Time : O(n * amount^2), Space: O(n * amount)
    public int solution2(int amount, int[] coins) {
        if (coins == null || amount < 0) {
            return 0;
        }
        return calc(amount,0, coins, new int[coins.length + 1][amount + 1]);
    }
    private int calc(int amount, int index, int[] coins, int[][] dp) {
        int res = 0;
        if (index == coins.length) {
            res = amount == 0 ? 1 : 0;
        } else {
            for (int i = 0; coins[index] * i <= amount; i ++) {
                int count = dp[index + 1][amount - coins[index] * i];
                if (count != 0) {
                    res += count == -1 ? 0 : count;
                } else {
                    res += calc(amount - coins[index] * i, index + 1, coins, dp);
                }
            }
        }
        dp[index][amount] = res == 0 ? -1 : res;
        return res;
    }

    // Solution 3: Dynamic programming
    private int solution3(int amount, int[] coins) {
        if (coins == null || amount < 0) {
            return 0;
        }
        if (coins.length == 0) {
            return amount > 0 ? 0 : 1;
        }
        int[][] dp = new int[coins.length][amount + 1]; // dp[i][j] 表示使用 coins[0..i] 货币下，组成钱数 j 元的方法数
        for (int k = 0; k < coins.length; k ++) {
            dp[k][0] = 1;   // 使用 coins[0..k] 货币组成钱数 0 元的方法数
        }
        for (int t = 1; t * coins[0] <= amount; t ++) {
            dp[0][t * coins[0]] = 1;    // 只使用 coins[0] 这一种货币，仅能组成其倍数面值，因此初始条件下 t * coins[0] 元的方法数均为 1;
        }
        for (int i = 1; i < coins.length; i ++) {
            for (int j = 1; j <= amount; j ++) {
                int count = 0;
                for (int k = 0; j - coins[i] * k >= 0; k ++) {
                    count += dp[i - 1][j - coins[i] * k];
                }
                dp[i][j] = count;
            }
        }
        return dp[coins.length - 1][amount];
    }
    // Solution 4: Dynamic programming (Optimal)
    private int solution4(int amount, int[] coins) {
        if (coins == null || amount < 0) {
            return 0;
        }
        if (coins.length == 0) {
            return amount > 0 ? 0 : 1;
        }
        int[][] dp = new int[coins.length][amount + 1]; // dp[i][j] 表示使用 coins[0..i] 货币下，组成钱数 j 元的方法数
        for (int k = 0; k < coins.length; k ++) {
            dp[k][0] = 1;   // 使用 coins[0..k] 货币组成钱数 0 元的方法数
        }
        for (int t = 1; t * coins[0] <= amount; t ++) {
            dp[0][t * coins[0]] = 1;
        }
        for (int i = 1; i < coins.length; i ++) {
            for (int j = 1; j <= amount; j ++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += (j - coins[i] >= 0) ? dp[i][j - coins[i]] : 0;
            }
        }
        return dp[coins.length - 1][amount];
    }
}