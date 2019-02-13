package _39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return lists;
        }
        dfs(0, 0, target, candidates, lists, new ArrayList<>());
        return lists;
    }
    private void dfs(int i, int sum, int target, int[] candidates, List<List<Integer>> lists, List<Integer> list) {
        if (sum > target) {
            return ;
        }
        if (sum == target) {
            lists.add(new ArrayList<>(list));
            return ;
        }
        for (int t = i; t < candidates.length; t ++) {
            sum += candidates[t];
            list.add(candidates[t]);
            dfs(t, sum, target, candidates, lists, list);
            list.remove(list.size() - 1);
            sum -= candidates[t];
        }
    }
}
