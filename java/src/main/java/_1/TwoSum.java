package _1;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return solution1(nums,target);
    }
    private int[] solution1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer complementIndex = map.get(target - nums[i]);
            if (complementIndex != null) {
                return new int[]{complementIndex,i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}