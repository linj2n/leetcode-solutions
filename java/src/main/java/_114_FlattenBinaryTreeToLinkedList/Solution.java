package _114_FlattenBinaryTreeToLinkedList;

import support.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return ;
        }
        doFlatten(root);
    }
    private TreeNode doFlatten(TreeNode p) {
        if (p.left == null && p.right == null) {
            return p;
        }
        TreeNode leftSideRightMost = null, rightSideRightMost = null;
        if (p.left != null && p.right != null) {
            leftSideRightMost = doFlatten(p.left);
            rightSideRightMost = doFlatten(p.right);
            TreeNode temp = p.right;
            p.right = p.left;
            leftSideRightMost.right = temp;
            p.left = null;
            return rightSideRightMost;
        }
        if (p.left != null) {
            leftSideRightMost = doFlatten(p.left);
            p.right = p.left;
            p.left = null;
            leftSideRightMost.right = null;
            return leftSideRightMost;
        }
        // p.right != null
        rightSideRightMost = doFlatten(p.right);
        return rightSideRightMost;
    }
}
