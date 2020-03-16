package _167;

import java.util.Arrays;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        return solution1(numbers, target);
    }

    private int[] solution1(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            while (l < r && numbers[l] + numbers[r] > target) {
                r --;
            }
            if (numbers[l] + numbers[r] == target) {
                return new int[] {l + 1, r + 1};
            }
            l ++;    
        }
        return null;
    }
}