package _50;

public class PowXN {
    public double myPow(double x, int n) {
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
}
