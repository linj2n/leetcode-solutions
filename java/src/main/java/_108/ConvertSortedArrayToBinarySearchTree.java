package _108;

import support.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return doBuild(nums, 0, nums.length - 1);
    }
    private TreeNode doBuild(int[] nums, int first, int last) {
        if (first > last) {
            return null;
        }
        int mid = first + (last - first) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = doBuild(nums, first, mid - 1);
        node.right = doBuild(nums, mid + 1, last);
        return node;
    }
}
