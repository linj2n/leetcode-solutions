package _103;

import support.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rows = new ArrayList<>();
        if (root == null) {
            return rows;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        List<Integer> row = new ArrayList<>();
        boolean leftToRight = true;
        TreeNode last = root, nextLast = null;
        while (!deque.isEmpty()) {
            if (leftToRight) {
                root = deque.removeFirst();
                if (root.left != null) {
                    deque.addLast(root.left);
                    nextLast = (nextLast == null) ? root.left : nextLast;
                }
                if (root.right != null) {
                    deque.addLast(root.right);
                    nextLast = (nextLast == null) ? root.right : nextLast;
                }
            } else {
                root = deque.removeLast();
                if (root.right != null) {
                    deque.addFirst(root.right);
                    nextLast = (nextLast == null) ? root.right : nextLast;
                }
                if (root.left != null) {
                    deque.addFirst(root.left);
                    nextLast = (nextLast == null) ? root.left : nextLast;
                }
            }
            row.add(root.val);
            if (root == last) {
                last = nextLast;
                nextLast = null;
                leftToRight = !leftToRight;
                rows.add(row);
                row = new ArrayList<>();
            }
        }
        return rows;
    }
}