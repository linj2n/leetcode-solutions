package _94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import support.TreeNode;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        return travelRecursively(root);
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
        list.add(root.val);
        travelRecursively(root.right, list);
    }

    // solution 2: Using stack
    public List<Integer> travelIteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
        }
        return list;
    }
}

