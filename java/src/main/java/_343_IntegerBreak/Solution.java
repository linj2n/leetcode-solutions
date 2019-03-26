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
        return calc(0, n, new int[n + 1][n + 1]);   
    }
    private int calc(int i, int n, int[][] dp) {
        int res = Integer.MIN_VALUE;
        if (i == n) {
            res = n == 0;    
        }
        dp[i][n] = res == Integer.MIN_VALUE ? -1 : res;
        return dp[i][n];
    }
}
