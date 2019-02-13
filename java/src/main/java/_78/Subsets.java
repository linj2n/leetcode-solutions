package _78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            lists.add(list);
            return lists;
        }
        dfs_2(0, nums, lists, list);
        return lists;
    }
    private void dfs_1(int k, int[] nums, List<List<Integer>> lists, List<Integer> list) {
        if (k == nums.length) {
            lists.add(new ArrayList<>(list));
            return ;
        }
        list.add(nums[k]);
        dfs_1(k + 1, nums, lists, list);
        list.remove(list.size() - 1);
        dfs_1(k + 1, nums, lists, list);
    }
    private void dfs_2(int i, int[] nums, List<List<Integer>> lists, List<Integer> list) {
        lists.add(new ArrayList<>(list));
        for (int t = i; t < nums.length; t ++) {
            list.add(nums[t]);
            dfs_2(t + 1, nums, lists, list);
            list.remove(list.size() - 1);
        }
    }
}

