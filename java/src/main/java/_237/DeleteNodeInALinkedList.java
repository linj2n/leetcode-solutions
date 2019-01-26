package _237;

import support.ListNode;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        solution1(node);
    }
    private void solution1(ListNode node) {
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        while (node.next != null) {
            dummy.next.val = node.next.val;
            node = node.next;
            dummy = dummy.next;
        }
        dummy.next = null;
    }
    private void solution2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
