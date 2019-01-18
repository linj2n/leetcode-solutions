package _145;

import support.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class BinaryTreePostorderTraversal {
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
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
            list.add(root.val);
        }
        Collections.reverse(list);
        return list;
    }
}