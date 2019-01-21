package _110;

import support.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return solution2(root);
    }

    // solution 1: Brute force
    private boolean solution1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return solution1(root.left) && solution1(root.right);
    }
    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // solution 2: Postorder traversal
    private boolean solution2(TreeNode root) {
        boolean[] result = new boolean[1];
        result[0] = true;
        treeDepth(root, 0, result);
        return result[0];
    }
    private int treeDepth(TreeNode root, int level, boolean[] result) {
        if (root == null) {
            return level;
        }
        int leftHeight = treeDepth(root.left, level + 1, result);
        if (result[0] == false) {
            return level;
        }

        int rightHeight = treeDepth(root.right, level + 1, result);
        if (result[0] == false) {
            return level;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            result[0] = false;
        }
        return Math.max(leftHeight, rightHeight);
    }
}