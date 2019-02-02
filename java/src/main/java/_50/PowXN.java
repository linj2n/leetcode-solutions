package _50;

public class PowXN {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double result = 1;
        for (int i = 0; i < Math.abs(n); i ++) {
            result *= x;
        }
        return (n > 0) ? result : (1 / result);
    }
}
