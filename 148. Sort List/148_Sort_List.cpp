/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* returnSpilitSubList(struct ListNode *head)
{
    if (!head || !head -> next)
        return head;
    struct ListNode *slower = head, *faster = head,*midSubListHead;
    while (faster-> next && faster -> next -> next)
    {
        slower = slower -> next;
        faster = faster -> next -> next;
    }
    midSubListHead = slower -> next;
    slower -> next = NULL;
    return midSubListHead;
}
struct ListNode* mergeTwoSortedList(struct ListNode* l1, struct ListNode* l2)
{
    struct ListNode* dummyHead = (struct ListNode *) malloc(sizeof(struct ListNode));
    dummyHead -> next = NULL;
    struct ListNode* walk = dummyHead;
    while (l1 && l2)
    {
        if (l1 -> val < l2 ->val)
        {
            struct ListNode *temp = l1 -> next;
            l1 -> next = walk -> next;
            walk -> next = l1;
            walk = l1;
            l1 = temp;
        }else{
            struct ListNode *temp = l2 -> next;
            l2 -> next = walk -> next;
            walk -> next = l2;
            walk = l2;
            l2 = temp;
        }
    }
    walk -> next = (l1 == NULL) ? l2 : l1;
    struct ListNode *head = dummyHead -> next;
    free(dummyHead);
    return head;
}

struct ListNode* sortList(struct ListNode* head) {
    if (head == NULL || head -> next == NULL)
        return head;
    struct ListNode *midSubListHead = returnSpilitSubList(head);
    head = sortList(head);
    midSubListHead = sortList(midSubListHead);
    return mergeTwoSortedList(head,midSubListHead);
}