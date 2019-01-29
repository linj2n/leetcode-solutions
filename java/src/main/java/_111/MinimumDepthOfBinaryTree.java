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
    private int dfs(TreeNode root, int count) {
        if (root.left == null && root.right == null) {
            return count;
        }
        int leftCount = Integer.MAX_VALUE;
        if (root.left != null) {
            leftCount = dfs(root.left, count + 1);
        }
        int rightCount = Integer.MAX_VALUE;
        if (root.right != null) {
            rightCount = dfs(root.right, count + 1);
        }
        return Math.min(leftCount, rightCount);
    }
}
