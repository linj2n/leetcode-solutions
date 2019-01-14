package _268;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        return solution3(nums);
    }

    // solution 1: Sorting
    private int solution1(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i) {
                return i;
            }
            i ++;
        }
        return i;
    }

    // solution 2: Using set
    private int solution2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i;
        for (i = 0; i < nums.length; i ++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return i;
    }

    // solution 3: Bit manipulation
    private int solution3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i ++) {
            missing = (missing ^ i ^ nums[i]);
        }
        return missing;
    }
}
