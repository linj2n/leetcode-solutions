package _199;

import support.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        TreeNode last = root, nextLast = null;
        while (!deque.isEmpty()) {
            TreeNode curr = deque.removeFirst();
            if (curr.left != null) {
                deque.addLast(curr.left);
                nextLast = curr.left;
            }
            if (curr.right != null) {
                deque.addLast(curr.right);
                nextLast = curr.right;
            }
            if (curr == last) {
                last = nextLast;
                list.add(curr.val);
            }
        }
        return list;
    }
}
