package _70;

public class ClimbingStairs {
    public int climbStairs(int n) {
        return solution2(n);
    }

    // Time Limit Exceeded
    private int solution1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return solution1(n - 1) + solution1(n - 2);
    }

    private int solution2(int n) {
        int i = 1, j = 1;
        int result = 1;
        for (int t = 1; t < n; t ++) {
            result = i + j;
            int temp = j;
            j = result;
            i = temp;
        }
        return result;
    }
}

