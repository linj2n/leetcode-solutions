package _99;

import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        serialize(root, inorderList);
        for (int i = 0; i < inorderList.size() - 1; i ++) {
            if (inorderList.get(i) >= inorderList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    private void serialize(TreeNode root, List<Integer> list) {
        if (root == null) {
            return ;
        }
        serialize(root.left, list);
        list.add(root.val);
        serialize(root.right, list);
    }
}
