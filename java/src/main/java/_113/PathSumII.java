package _113;

import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<Integer> path = new ArrayList<>();
        pathSum(root, sum, paths, path);
        return paths;
    }
    private void pathSum(TreeNode root, int sum , List<List<Integer>> paths, List<Integer> path) {

        sum -= root.val;
        path.add(root.val);

        boolean isLeafAndMatched = (root.left == null && root.right == null) && sum == 0;
        if (isLeafAndMatched) {
            paths.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            pathSum(root.left, sum, paths, path);
        }
        if (root.right != null) {
            pathSum(root.right, sum, paths, path);
        }
        path.remove(path.size() - 1);
    }
}