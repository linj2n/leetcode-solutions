package _145_BinaryTreePostorderTraversal;

import support.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        return travelIteratively(root);
    }

    // solution 1: Recursion
    private List<Integer> travelRecursively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        travelRecursively(root, list);
        return list;
    }

    private void travelRecursively(TreeNode root, List<Integer> list) {
        if (root == null) {
            return ;
        }
        travelRecursively(root.left, list);
        travelRecursively(root.right, list);
        list.add(root.val);
    }

    // solution 2: Iterating
    private List<Integer> travelIteratively(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode curr = s1.pop();
            s2.push(curr);
            if (curr.left != null) {
                s1.push(curr.left);
            }
            if (curr.right != null) {
                s1.push(curr.right);
            }
        }
        while (!s2.isEmpty()) {
            nodes.add(s2.pop().val);
        }
        return nodes;
    }
}