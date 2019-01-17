package _94;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return recursiveTravel(root, list);
    }
    // solution 1: Recursion
    private List<Integer> recursiveTravel(TreeNode root, List<Integer> list) {
        inorderTraversal(root, list);
        return list;
    }
    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return ;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        this.val = x;
    }
}