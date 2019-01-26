package _83;

import support.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode l1 = head, l2 = head.next;
        while (l1 != null && l2 != null) {
            while (l2 != null && l1.val == l2.val) {
                l2 = l2.next;
            }
            l1.next = l2;

            l1 = l1.next;
            l2 = (l2 != null) ? l2.next : null;
        }
        return head;
    }
}
