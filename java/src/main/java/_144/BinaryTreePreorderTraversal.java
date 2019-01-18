package _144;


import support.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
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
        list.add(root.val);
        travelRecursively(root.left, list);
        travelRecursively(root.right, list);
    }

    // solution 2: Iterating
    private List<Integer> travelIteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return list;

    }
}
