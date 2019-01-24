package _230;

import support.TreeNode;

public class KthSmallestElementInaBST {
    private int count;
    private int val;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        doFind(root, k);
        return val;
    }
    private void doFind(TreeNode root, int k) {
        if (root == null) {
            return ;
        }
        doFind(root.left, k);
        if (++ count == k) {
            val = root.val;
            return ;
        }
        doFind(root.right, k);
    }
}
