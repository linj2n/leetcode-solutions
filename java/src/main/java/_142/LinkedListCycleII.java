package _142;

import support.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        // find meeting node
        if (head == null || head.next == null) {
            return null;
        }
        ListNode low = head, fast = head.next;
        ListNode meetingNode = null;
        while (low != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            low = low.next;
            fast = fast.next.next;
        }
        meetingNode = low;

        // counting the length of cycle-list
        int counts = 1;
        for (ListNode walk = meetingNode.next; walk != meetingNode; walk = walk.next) {
            counts ++;
        }

        ListNode entry = head, post = head;
        for (int i = 0; i < counts; i ++) {
            post = post.next;
        }
        while (entry != post) {
            entry = entry.next;
            post = post.next;
        }
        return entry;
    }
}
