package _1008_ConstructBinarySearchTreeFromPreorderTraversal;

import support.TreeNode;

public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return doBuild(preorder, 0, preorder.length - 1);
    }
    private TreeNode doBuild(int[] pre, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(pre[l]);
        int mid = l + 1;
        while (mid <= r && pre[mid] < pre[l]) {
            mid ++;
        }
        root.left = doBuild(pre, l + 1, mid - 1);
        root.right = doBuild(pre, mid, r);
        return root;
    }
}
