package _66;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int k = 1, sum = 0;
        for (int i = digits.length - 1; i >= 0; -- i) {
            sum = k + digits[i];
            digits[i] = sum % 10;
            k = sum / 10;
            if (sum < 10) {
                return digits;
            }
        }
        int[] newDigit = new int[digits.length + 1];
        newDigit[0] = 1;
        return newDigit;
    }
}
