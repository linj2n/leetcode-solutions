package _1;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return solution1(nums,target);
    }
    private int[] solution1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i],i);
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j ++) {
            if (map.containsKey(target - nums[j]) && map.get(target - nums[j]) != j) {
                list.add(j);
                list.add(map.get(target - nums[j]));
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}