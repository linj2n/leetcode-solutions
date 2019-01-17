package _169;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        return majorityElement(nums,0,nums.length - 1);
    }

    // solution 1: Using hash table
    public int solution1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int times = nums.length / 2, counts;
        for (int i : nums) {
            Integer oldCounts = map.get(i);
            counts = (oldCounts != null) ? oldCounts + 1 : 1;
            if (counts > times) {
                return i;
            }
            map.put(i,counts);
        }
        throw new RuntimeException("Invalid input");
    }

    // solution 2: Using Sorting
    public int solution2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // solution 3: Divide and Conquer
    private int majorityElement(int[] nums, int first, int last) {
        if (first == last) {
            return nums[first];
        }

        int mid = first + (last - first) / 2;
        int mostFrequentlyValueInLeft = majorityElement(nums, first, mid);
        int mostFrequentlyValueInRight = majorityElement(nums, mid + 1, last);

        if (mostFrequentlyValueInLeft == mostFrequentlyValueInRight) {
            return mostFrequentlyValueInLeft;
        }
        return findingMostFrequentlyValueInRange(nums,mostFrequentlyValueInLeft,mostFrequentlyValueInRight,first,last);
    }

    private int findingMostFrequentlyValueInRange(int[] nums, int value1, int value2, int lo, int hi) {
        int countValue1 = 0, countValue2 = 0;
        while (lo <= hi) {
            if (nums[lo] == value1) {
                ++ countValue1;
            } else if(nums[lo] == value2) {
                ++ countValue2;
            }
            ++ lo;
        }
        return countValue1 > countValue2 ? value1 : value2;
    }

    // TODO: solution 4: Bit manipulation

}
