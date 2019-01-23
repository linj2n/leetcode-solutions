package _297;

import support.TreeNode;

public class SerializeAndDeserializeBinaryTree {
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
        int[] index = new int[1];
        return doDeserialize(dataChars, index);
    }
    private TreeNode doDeserialize(char[] data, int[] index) {
        if (index[0] >= data.length) {
            return null;
        }
        int k = index[0];
        while (data[k] == ' ') {
            k ++;
        }
        if (data[k] == '#') {
            index[0] = k + 2;
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
        index[0] = ++ k;
        node.left = doDeserialize(data, index);
        node.right = doDeserialize(data, index);
        return node;
    }
}