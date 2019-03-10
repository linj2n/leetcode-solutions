package _1_TowSum;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        return calculByDFS(nums, target);
    }
    // solution 1
    private int[] calculByDFS(int[] nums, int target) {
        int[] res = new int[2];
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, 0, target, used, res);
        return res;
    }
    private void dfs(int[] nums, int u, int count, int target, boolean[] used, int[] res) {
        if (u == nums.length || count == 2) {
            if (target == 0 && count == 2) {
                for (int i = 0, k = 0; i < used.length; i ++) {
                    if (used[i]) {
                        res[k ++] = i;
                    }
                }
            }
            return ;
        }
        used[u] = true;
        dfs(nums, u + 1, count + 1, target - nums[u], used, res);
        used[u] = false;
        dfs(nums, u + 1, count, target, used, res);

    }
    // solution 2
    private int[] usingMap(int[] nums, int target) {
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