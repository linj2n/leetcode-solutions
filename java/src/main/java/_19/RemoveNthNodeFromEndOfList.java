package _19;

import support.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, last = dummy;
        for (int i = 0; i < n; i ++) {
            last = last.next;
        }
        while (last.next != null) {
            last = last.next;
            pre = pre.next;
        }
        ListNode temp = pre.next;
        pre.next = temp.next;
        return dummy.next;
    }
}
