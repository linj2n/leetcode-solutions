package _257;

import support.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        String path = "";
        doFindPath(root, paths, path);
        return paths;
    }
    private void doFindPath(TreeNode root, List<String> paths, String path) {
        path += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            paths.add(path);
            return ;
        }
        path += "->";
        if (root.left != null) {
            doFindPath(root.left, paths, path);
        }
        if (root.right != null) {
            doFindPath(root.right, paths, path);
        }
    }
}
