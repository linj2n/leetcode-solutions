package _343_IntegerBreak;

public class Solution {
    public int integerBreak(int length) {
        return solution1(length);
    }
    private int solution1(int length) {
        if (length < 2 || length > 58) {
            return -1;
        }
        if (length <= 3) {
            return length - 1;
        }
        int res = 1;
        if (length % 3 == 1) {
            res *= 4;
            length -= 4;
        } else if (length % 3 == 2) {
            res *= 2;
            length -= 2;
        }
        while (length != 0) {
            res *= 3;
            length -= 3;
        }
        return res;
    }
    private int solution2(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int left = Math.max(j, dp[j]);
                int right = Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(dp[i], left * right);
            }
        }
        return dp[n];    
    }
}
