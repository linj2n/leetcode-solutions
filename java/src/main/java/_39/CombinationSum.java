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
        // backtracking(new ArrayList<>(), 0, 0, target, candidates, lists);
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
            list.add(candidates[t]);
            dfs(t, sum + candidates[t] target, candidates, lists, list);
            list.remove(list.size() - 1);
        }
    }

    private void backtracking(List<Integer> list, int i, int sum, int target, int[] candidates, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return ;
        }
        if (i == candidates.length) {
            return ;
        }
        int t = 0;
        for (; sum + t * candidates[i] <= target; t ++) { 
            backtracking(list, i + 1, sum + t * candidates[i], target, candidates, ans);
            list.add(candidates[i]);
        }
        while (t != 0) {
            list.remove(list.size() - 1);
            t --;
        }
    }
}
