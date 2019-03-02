package _233_NumberOfDigitOne;

public class Solution {
    public int countDigitOne(int n) {
        int[] digits = new int[10];
        int start = digits.length;
        while (n != 0) {
            digits[-- start] = n % 10;
            n /= 10;
        }
        int res = 0;
        for (int i = start; i < digits.length; i ++) {
            int left = 0, right = 0, digitsCount = 1;
            for (int j = start; j < i; j ++) {
                left = left * 10 + digits[j];
            }
            for (int k = i + 1; k < digits.length; k ++) {
                right = right * 10 + digits[k];
                digitsCount *= 10;
            }
            res += left * digitsCount;
            if (digits[i] == 1) {
                res += (right + 1);
            } else if (digits[i] > 1) {
                res += digitsCount;
            }
        }
        return res;
    }
}
