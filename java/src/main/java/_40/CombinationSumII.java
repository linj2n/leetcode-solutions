package _40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (candidates == null) {
            return ans;
        }
        Arrays.sort(candidates);
        dfs(path, 0, 0, candidates, target, ans);
        backtracking(path, 0, 0, target, candidates, ans);
        return ans;    
    }
    private void dfs(List<Integer> path, int sum, int start, int[] candidates, int target, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return ;
        }
        if (start == candidates.length || sum > target) {
            return ;
        }
        
        for (int i = start; i < candidates.length; i ++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(path, sum + candidates[i], i + 1, candidates, target, ans);
            path.remove(path.size() - 1);
        }
    }

    private void backtracking(List<Integer> list, int i, int sum, int target, int[] candidates, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return ;
        }
        if (i == candidates.length || sum > target) {
            return ;
        }
        int u = i; 
        while (u < candidates.length && candidates[u] == candidates[i]) {
            u ++;
        }
        
        int t = 0;
        for (; t <= u - i; t ++) {
            backtracking(list, u, sum + t * candidates[i], target, candidates, ans);
            list.add(candidates[i]);
        }
        
        while (t != 0) {
            list.remove(list.size() - 1);
            t --;
        }
    }
}
