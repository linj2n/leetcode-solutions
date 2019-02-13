package _47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);
        boolean[] isSelected = new boolean[nums.length];
        dfs(nums, isSelected, lists, new ArrayList<>());
        return lists;
    }
    private void dfs(int[] nums, boolean[] isSelected, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isSelected[i] || i > 0 && nums[i] == nums[i - 1] && !isSelected[i - 1]) {
                continue;
            }
            isSelected[i] = true;
            list.add(nums[i]);
            dfs(nums, isSelected, lists, list);
            list.remove(list.size() - 1);
            isSelected[i] = false;
        }
    }
}
