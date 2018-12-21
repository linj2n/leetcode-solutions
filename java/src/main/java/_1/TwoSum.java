package _1;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return solution1(nums,target);
    }
    private int[] solution1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int supplement = target - nums[i];
            if (map.containsKey(supplement)) {
                return new int[]{map.get(supplement),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}