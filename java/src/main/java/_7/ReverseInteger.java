package _7;

public class ReverseInteger {
    public int reverse(int x) {
        long inverse = 0;
        int temp = Math.abs(x);
        while (temp != 0) {
            inverse = inverse * 10 + temp % 10;
            temp /= 10;
        }
        if (inverse > Integer.MAX_VALUE || inverse < Integer.MIN_VALUE ) {
            return 0;
        }
        int result = (int) inverse;
        return (x < 0) ? -result : result;
    }
}
