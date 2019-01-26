package _141;

import support.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        return solution1(head);
    }
    private boolean solution1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    private boolean solution2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode low = head, fast = head;
        do {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            low = low.next;
            fast = fast.next.next;
        } while (low != fast);
        return true;
    }
}
