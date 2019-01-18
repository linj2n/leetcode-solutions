package _102;

import support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = root, nextLast = null;
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (curr.left != null) {
                queue.add(curr.left);
                nextLast = curr.left;
            }
            if (curr.right != null) {
                queue.add(curr.right);
                nextLast = curr.right;
            }
            list.add(curr.val);
            if (curr == last) {
                lists.add(list);
                list = new ArrayList<>();
                last = nextLast;
            }
        }
        return lists;
    }
}