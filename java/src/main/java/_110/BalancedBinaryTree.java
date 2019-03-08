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
    private boolean result = true;
    public boolean solution2(TreeNode root) {
        if (root == null) {
            return result;
        }
        doCheck(root);
        return result;
    }
    private int doCheck(TreeNode root) {
        if (!result) {
            return 1;
        }
        if (root == null) {
            return 0;
        }
        int leftDepth = doCheck(root.left);
        int rightDepth = doCheck(root.right);
        if (Math.abs(rightDepth - leftDepth) > 1) {
            result = false;
        }
        return Math.max(rightDepth, leftDepth) + 1;
    }
    // Another solution to postorder-traversal
    private int doCheck(TreeNode root, int depth) {
        if (!result) {
            return Integer.MAX_VALUE;
        }
        if (root == null) {
            return depth;
        }
        int leftDepth = (root.left == null) ? depth : doCheck(root.left, depth + 1);
        int rightDepth = (root.right == null) ? depth : doCheck(root.right, depth + 1);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            result = false;
        }
        return Math.max(leftDepth, rightDepth);
    }

}