package _106;

import support.TreeNode;

import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            valToIndex.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1,valToIndex);
    }
    private TreeNode buildTree(int[] inorder, int inFirst, int inLast, int[] postorder, int posFirst, int posLast, Map<Integer, Integer> valToIndex) {
        if (inFirst > inLast) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[posLast]);
        int index = valToIndex.get(postorder[posLast]);
        node.left = buildTree(inorder, inFirst, index - 1,
                postorder, posFirst, posFirst + index - inFirst - 1,
                valToIndex);
        node.right = buildTree(inorder, index + 1, inLast,
                postorder,  posFirst + index - inFirst, posLast - 1,
                valToIndex);
        return node;
    }

}