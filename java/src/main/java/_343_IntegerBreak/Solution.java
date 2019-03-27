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
    // Dynamic programming (Bottom-up)
    private int solution2(int n) {
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i ++) {
            for (int j = 1; i - j > 0; j ++) {
                dp[i] = Math.max(j * (i - j), j * dp[i - j]);
            }
        }
        return dp[n];
    }
    // Dynamic programming (Bottom-up)
    private int solution4(int n) {
        if (n <= 3) {
            return n < 2 ? 0 : n - 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i ++) {
            for (int j = 1; j < i / 2; j ++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }
        return dp[n];
    }
}
