package _107;

import support.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rows = new ArrayList<>();
        if (root == null) {
            return rows;
        }
        List<Integer> row = new ArrayList<>();
        TreeNode last = root, nextLast = null;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.removeFirst();
            if (curr.left != null) {
                queue.addLast(curr.left);
                nextLast = curr.left;
            }
            if (curr.right != null) {
                queue.addLast(curr.right);
                nextLast = curr.right;
            }
            row.add(curr.val);
            if (curr == last) {
                last = nextLast;
                nextLast = null;
                rows.add(row);
                row = new ArrayList<>();
            }
        }
        Collections.reverse(rows);
        return rows;
    }
}
