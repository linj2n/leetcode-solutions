package _21;

import support.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), walk = dummy;
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                walk.next = cur1;
                cur1 = cur1.next;
            } else {
                walk.next = cur2;
                cur2 = cur2.next;
            }
            walk = walk.next;
        }
        if (cur1 != null) {
            walk.next = cur1;
        }
        if (cur2 != null) {
            walk.next = cur2;
        }
        return dummy.next;
    }
}
