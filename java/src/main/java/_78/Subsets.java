package _78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            sets.add(new ArrayList<>());
            return sets;
        }
        boolean[] seleted = new boolean[nums.length];
        dfs(0, nums, seleted, sets);
        return sets;
    }
    private void dfs(int u, int[] nums, boolean[] selected, List<List<Integer>> sets) {
        if (u == nums.length) {
            List<Integer> set = new ArrayList<>();
            for (int i = 0; i < selected.length; i ++) {
                if (selected[i]) {
                    set.add(nums[i]);
                }
            }
            sets.add(set);
            return ;
        }
        selected[u] = true;
        dfs(u + 1, nums, selected, sets);
        selected[u] = false;
        dfs(u + 1, nums, selected, sets);
    }
}

