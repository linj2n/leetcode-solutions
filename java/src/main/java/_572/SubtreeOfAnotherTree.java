package _572;

import support.TreeNode;

class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = false;
        if (s == null || t == null) {
            return result;
        }
        if (s.val == t.val) {
            result = doCheck(s, t);
        }
        if (!result) {
            result = isSubtree(s.left, t);
        }
        if (!result) {
            result = isSubtree(s.right, t);
        }
        return result;
    }
    private boolean doCheck(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && doCheck(s.left, t.left) && doCheck(s.right, t.right);
    }
}