package _167;

import java.util.Arrays;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        return solution1(numbers, target);
    }

    private int[] solution1(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1, sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                --right;
            } else {
                ++left;
            }
        }
        return null;
    }
}