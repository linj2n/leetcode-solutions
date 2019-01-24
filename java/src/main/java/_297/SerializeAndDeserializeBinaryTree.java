package _297;

import support.TreeNode;

public class SerializeAndDeserializeBinaryTree {

    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "# ";
        }
        return String.valueOf(root.val) + " "+ serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        char[] dataChars = data.toCharArray();
        return doDeserialize(dataChars);
    }
    private TreeNode doDeserialize(char[] data) {
        if (index >= data.length) {
            return null;
        }
        int k = index;
        while (data[k] == ' ') {
            k ++;
        }
        if (data[k] == '#') {
            index = k + 2;
            return null;
        }
        int val = 0;
        boolean isNegativeNumber = false;
        while (data[k] != ' ') {
            if (data[k] == '-') {
                isNegativeNumber  = true;
            } else {
                val = val * 10 + (data[k] - '0');
            }
            k ++;
        }
        val = (isNegativeNumber) ? -val : val;
        TreeNode node = new TreeNode(val);
        index = ++ k;
        node.left = doDeserialize(data);
        node.right = doDeserialize(data);
        return node;
    }
}
