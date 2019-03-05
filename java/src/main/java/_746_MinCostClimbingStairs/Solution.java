package _746_MinCostClimbingStairs;

import java.util.Arrays;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null ) {
            return 0;
        }
        int[] dp = Arrays.copyOf(cost, cost.length + 1);
        for (int j = 2; j < dp.length; j ++) {
            dp[j] += Math.min(dp[j - 1], dp[j - 2]);
        }
        return dp[dp.length - 1];
    }
}
