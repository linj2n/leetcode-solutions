package _148_SortList;

import support.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode h1) {
        if (h1 == null || h1.next == null) {
            return h1;
        }
        ListNode h2 = splitList(h1);
        h1 = mergeSort(h1);
        h2 = mergeSort(h2);
        return mergeTwoSortedLists(h1, h2);
    }
    private ListNode splitList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
    private ListNode mergeTwoSortedLists(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode p = dummy, curr = null;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                curr = h1;
                h1 = h1.next;
                curr.next = p.next;
                p.next = curr;
                p = p.next;
            } else {
                curr = h2;
                h2 = h2.next;
                curr.next = p.next;
                p.next = curr;
                p = p.next;
            }
        }
        if (h1 != null) {
            p.next = h1;
        }
        if (h2 != null) {
            p.next = h2;
        }
        return dummy.next;
    }
}