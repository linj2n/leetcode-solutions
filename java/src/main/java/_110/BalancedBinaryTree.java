package _110;

import support.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return solution1(root);
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
}
