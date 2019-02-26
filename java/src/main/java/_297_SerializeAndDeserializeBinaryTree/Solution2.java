package _297_SerializeAndDeserializeBinaryTree;

import support.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        String res = "[";
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.removeFirst();
            if (curr == null) {
                res += "null";
            } else {
                res += curr.val;
                queue.addLast(curr.left);
                queue.addLast(curr.right);
            }
            res += (queue.isEmpty()) ? "" : ",";
        }
        res += "]";
        System.out.println(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (data.isEmpty()) {
            return null;
        }
        String[] dataArr = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[i ++]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.removeFirst();
            if (!dataArr[i].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(dataArr[i]));
                curr.left = leftNode;
                queue.addLast(leftNode);
            }
            i ++;
            if (!dataArr[i].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(dataArr[i]));
                curr.right = rightNode;
                queue.addLast(rightNode);
            }
            i ++;
        }
        return root;
    }
}
