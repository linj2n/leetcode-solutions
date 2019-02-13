package _77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return null;
        }
        if (k > n) {
            return lists;
        }
        dfs(1, k, n, lists, new ArrayList<>());
        return lists;
    }
    private void dfs(int i, int k, int n, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return ;
        }
        for (int t = i; t <= n; t ++) {
            list.add(t);
            dfs(t + 1, k, n, lists, list);
            list.remove(list.size() - 1);
        }
    }
}
