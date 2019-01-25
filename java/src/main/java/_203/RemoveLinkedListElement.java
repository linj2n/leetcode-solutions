package _203;

import support.ListNode;

public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                ListNode dNode = curr.next;
                curr.next = dNode.next;
                dNode.next = null;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
