package _268_MissingNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int missingNumber(int[] nums) {
        return solution4(nums);
    }

    // solution 1: Sorting
    // Time: O(nlogn), Space: O(n)
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
    // Time: O(n), Space: O(n)
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
    // Time: O(n), space: O(1)
    private int solution3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i ++) {
            missing = (missing ^ i ^ nums[i]);
        }
        return missing;
    }

    // solution 4: Sum
    // Time: O(n), space: O(1)
    private int solution4(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int n : nums){
            sum -= n;
        }
        return sum;
    }
}
