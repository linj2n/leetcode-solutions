package _111;

import support.TreeNode;

public class MinimumDepthOfBinaryTree {
    private int minimum = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doFind(root, 1);
        return minimum;
    }
    public void doFind(TreeNode root, int count) {
        if (root.left == null && root.right == null) {
            minimum = Math.min(minimum, count);
            return ;
        }
        if (root.left != null) {
            doFind(root.left, count + 1);
        }
        if (root.right != null) {
            doFind(root.right, count + 1);
        }
    }
}
