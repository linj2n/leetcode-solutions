package _206;

import support.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return reverseListIteratively(head);
    }
    private ListNode reverseListIteratively(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode walk = head;
        while (walk != null) {
            ListNode curr = walk;
            walk = walk.next;

            ListNode temp = dummy.next;
            dummy.next = curr;
            curr.next = temp;

        }
        return dummy.next;
    }
}
