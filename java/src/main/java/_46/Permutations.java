package _46;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] isSelected = new boolean[nums.length];
        dfs(0, nums, isSelected, list, lists);
        return lists;
    }
    private void dfs(int u, int[] nums, boolean[] isSelected, List<Integer> list, List<List<Integer>> lists) {
        if (u == nums.length) {
            lists.add(new ArrayList<>(list));
            return ;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                list.add(nums[i]);
                dfs(u + 1, nums, isSelected, list, lists);
                list.remove(list.size() - 1);
                isSelected[i] = false;
            }
        }
    }
}
