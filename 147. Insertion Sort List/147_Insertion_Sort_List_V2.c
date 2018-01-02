/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* insertionSortList(struct ListNode* head) {
    if (!head)
        return head;
    struct ListNode *dummyHead = (struct ListNode*) malloc(sizeof(struct ListNode));
    dummyHead -> next = NULL;
    struct ListNode *curNode = head;

    while (curNode)
    {
        struct ListNode *walk = dummyHead, *temp = NULL;
        while (walk -> next && (walk -> next -> val < curNode -> val))
            walk = walk -> next;
        temp = curNode -> next;
        curNode -> next = walk -> next;
        walk -> next = curNode;
        curNode = temp;
    }
    head = dummyHead -> next;
    free(dummyHead);
    return head;
}