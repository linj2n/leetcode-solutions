package _82;

import support.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, walk = dummy.next.next;
        while (pre.next != null && walk != null) {
            if (pre.next.val == walk.val) {
                while (walk != null && pre.next.val == walk.val) {
                    walk = walk.next;
                }
                pre.next = walk;
            } else {
                pre = pre.next;
            }
            walk = (walk != null) ? walk.next : null;
        }
        return dummy.next;
    }
}
