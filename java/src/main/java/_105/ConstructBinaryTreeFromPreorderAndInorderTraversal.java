package _105;

import support.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            valToIndex.put(inorder[i],i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valToIndex);
    }
    private TreeNode buildTree(int[] preorder, int preFirst, int preLast, int[] inorder, int inFirst, int inLast, Map<Integer, Integer> valToIndex) {
        if (preFirst > preLast) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preFirst]);
        int index = valToIndex.get(preorder[preFirst]);
        node.left = buildTree(preorder, preFirst + 1, preFirst + index - inFirst, inorder, inFirst, index - 1, valToIndex);
        node.right = buildTree(preorder, preFirst + index - inFirst + 1, preLast, inorder, index + 1, inLast, valToIndex);
        return node;
    }
}