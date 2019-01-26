package _160;

import support.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return solution3(headA, headB);
    }
    private ListNode solution1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            if (!set.add(curr)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
    private ListNode solution2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null || headA.next == null || headB.next == null) {
            return null;
        }
        ListNode curr = headA;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = headA;

        ListNode low = headB, fast = headB;
        do {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            low = low.next;
            fast = fast.next.next;
        } while (low != fast);
        return low.next;
    }
    private ListNode solution3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2){
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
