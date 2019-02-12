package _77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private int n;
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> sets = new ArrayList<>();
        this.n = n;
        this.k = k;
        boolean[] selected = new boolean[n];
        dfs(0, 0, sets, selected);
        return sets;
    }
    private void dfs(int u, int nums, List<List<Integer>> sets, boolean[] selected) {
        if (n < k) {
            return ;
        }
        if (nums == k) {
            List<Integer> set = new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                if (selected[i]) {
                    set.add(i + 1);
                }
            }
            sets.add(set);
            return ;
        }
        if (u == n) {
            return ;
        }
        selected[u] = true;
        dfs(u + 1, nums + 1, sets, selected);
        selected[u] = false;
        dfs(u + 1, nums, sets, selected);
    }
}
