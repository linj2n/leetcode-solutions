package _138;

import support.RandomListNode;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode curr = head;
        RandomListNode cpHead = null, cpNode = null;
        RandomListNode temp = null;
        while (curr != null) {
            cpNode = new RandomListNode(curr.label);
            temp = curr.next;
            curr.next = cpNode;
            cpNode.next = temp;
            curr = temp;
        }

        curr = head;
        while (curr != null) {
            cpNode = curr.next;
            cpNode.random = (curr.random != null) ? curr.random.next : null;
            curr = cpNode.next;
        }

        cpHead = head.next;
        curr = head;
        while (curr != null) {
            temp = curr.next.next;
            cpNode = curr.next;
            curr.next = cpNode.next;
            cpNode.next = (curr.next != null) ? curr.next.next : null;
            curr = temp;
        }
        return cpHead;
    }
}
