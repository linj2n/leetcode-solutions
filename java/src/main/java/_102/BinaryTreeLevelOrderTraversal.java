package _102;

import support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rows = new ArrayList<>();
        if (root == null) {
            return rows;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode last = root, nextLast = null;
        List<Integer> row = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (curr.left != null) {
                queue.add(curr.left);
                nextLast = curr.left;
            }
            if (curr.right != null) {
                queue.add(curr.right);
                nextLast = curr.right;
            }
            row.add(curr.val);
            if (curr == last) {
                rows.add(row);
                row = new ArrayList<>();
                last = nextLast;
            }
        }
        return rows;
    }
}