package _543;

import support.TreeNode;

public class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return diameter;
    }
    private int dfs(TreeNode root, int count) {
        if (root.left == null && root.right == null) {
            return count;
        }
        int leftDepth = 0;
        if (root.left != null) {
            leftDepth = dfs(root.left, count) + 1;
        }
        int rightDepth = 0;
        if (root.right != null) {
            rightDepth = dfs(root.right, count) + 1;
        }
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth);
    }
}
