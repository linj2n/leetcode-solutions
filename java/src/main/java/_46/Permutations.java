package _46;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] selected = new boolean[nums.length];
        dfs(0, nums, selected, list, lists);
        return lists;
    }
    private void dfs(int u, int[] nums, boolean[] selected, List<Integer> list, List<List<Integer>> lists) {
        if (u == nums.length) {
            lists.add(new ArrayList<>(list));
            return ;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (!selected[i]) {
                list.add(nums[i]);
                selected[i] = true;
                dfs(u + 1, nums, selected, list, lists);
                list.remove(list.size() - 1);
                selected[i] = false;
            }
        }
    }
}
