package _101;

import support.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doCheck(root.left, root.right);
    }
    private boolean doCheck(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null && root2 == null;
        }
        return root1.val == root2.val && doCheck(root1.left, root2.right) && doCheck(root1.right, root2.left);
    }
}
