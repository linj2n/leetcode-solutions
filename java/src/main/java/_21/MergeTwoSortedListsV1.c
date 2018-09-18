/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    if(l1==NULL)
        return l2;
    if(l2==NULL)
        return l1;
    struct ListNode *dummyHead = (struct ListNode*) malloc(sizeof(struct ListNode));
    dummyHead -> next = NULL;
    struct ListNode *f = l1, *s = l2, *t = dummyHead;
    while (l1 && l2)
    {
        if (l1 -> val < l2 -> val)
        {
            t -> next = l1;
            t = l1;
            l1 = l1 -> next;
        }else{
            t -> next = l2;
            t = l2;
            l2 = l2 -> next;
        }
    }
    t -> next = NULL;
    if (l1)
    {
        t -> next = l1;
    }
    if (l2)
    {
        t -> next = l2;
    }
    return dummyHead -> next;
    
}