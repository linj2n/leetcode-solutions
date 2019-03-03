package _400_NthDigit;

public class Solution {
    public int findNthDigit(int n) {
        long i = 1, base = 1, s = 9;
        while (n > i * s) {
            n -= (i * s);
            base *= 10;
            s *= 10;
            i ++;
        }
        int numbers = (int)(base + (n + i - 1) / i - 1);
        int kthDigit =(int)((n % i == 0) ? i : n % i);
        for (int j = 0; j < i - kthDigit; j ++) {
            numbers /= 10;
        }
        return numbers % 10;
    }
}
