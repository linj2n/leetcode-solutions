package _116;

import support.TreeLinkNode;

import java.util.Deque;
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return ;
        }
        Deque<TreeLinkNode> deque = new LinkedList<>();
        deque.addLast(root);
        TreeLinkNode last = root, nextLast = null;
        while (!deque.isEmpty()) {
            TreeLinkNode curr = deque.removeFirst();
            if (curr.left != null) {
                nextLast = curr.left;
                deque.addLast(curr.left);
            }

            if (curr.right != null) {
                nextLast = curr.right;
                deque.addLast(curr.right);
            }
            if (curr == last) {
                last = nextLast;
                curr.next = null;
            } else {
                curr.next = deque.getFirst();
            }
        }
    }
}
