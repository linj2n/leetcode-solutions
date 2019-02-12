package _50;

public class PowX_N {
    public double myPow(double x, int n) {
        return dfs(x, n);
    }


    // solved iteratively
    private double solvingIteratively(double x, int n) {
        double res = 1;
        long absOfN = Math.abs((long)n);
        while (absOfN != 0) {
            if ((absOfN & 1) != 0) {
                res *= x;
            }
            absOfN >>= 1;
            x *= x;
        }
        return (n > 0) ? res : (1 / res);
    }

    // solved recursively
    private double dfs(double x, long n) {
        if ( n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n == 0) {
            return 1;
        }
        return (n % 2 == 0) ? dfs(x * x, n / 2) : x * dfs(x * x, n / 2);
    }
}
