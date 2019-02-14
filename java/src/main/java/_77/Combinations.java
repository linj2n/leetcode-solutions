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
        // dfs_2(1, k, n, lists, new ArrayList<>());
        dfs_1(0, k, n, lists, new ArrayList<>());
        return lists;
    }
    private void dfs_2(int i, int k, int n, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return ;
        }
        for (int t = i; t <= n; t ++) {
            list.add(t);
            dfs_2(t + 1, k, n, lists, list);
            list.remove(list.size() - 1);
        }
    }
    private void dfs_1(int i, int k , int n, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return ;
        }
        if (i == n) {
            return ;
        }
        dfs_1(i + 1, k, n, lists, list);
        list.add(i + 1);
        dfs_1(i + 1, k, n, lists, list);
        list.remove(list.size() - 1);
    }
}
