package _111;

import support.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 1);
    }

    // BFS
    private int bfs(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int count = 1;
        TreeNode last = root, nextLast = null;
        while (!deque.isEmpty()) {
            TreeNode curr = deque.removeFirst();
            if (curr.left == null && curr.right == null) {
                break;
            }
            if (curr.left != null) {
                deque.addLast(curr.left);
                nextLast = curr.left;
            }
            if (curr.right != null) {
                deque.addLast(curr.right);
                nextLast = curr.right;
            }
            if (curr == last) {
                count ++;
                last = nextLast;
            }
        }
        return count;
    }

    // DFS
    private int dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }
        int leftDepth = (root.left == null) ? Integer.MAX_VALUE : dfs(root.left, depth + 1);
        int rightDepth = (root.right == null) ? Integer.MAX_VALUE : dfs(root.right, depth + 1);
        return Math.min(leftDepth, rightDepth);
    }
}
