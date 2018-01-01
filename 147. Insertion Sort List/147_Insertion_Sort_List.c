/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* insertionSortList(struct ListNode* head) {
    if (head == NULL || head->next == NULL)
        return head;
    struct ListNode *newHead = (struct ListNode *) malloc(sizeof(struct ListNode));
    newHead-> next = head;
    newHead-> val = 0;
    struct ListNode *pos = newHead, *preCurr = newHead -> next;
    while (preCurr -> next)
    {
    	pos = newHead;
		while (pos != preCurr && pos -> next -> val < preCurr -> next -> val){
    		pos = pos -> next;
    	}

    	if (pos == preCurr)
    	{
    		preCurr = preCurr -> next;
    	}else{
	    	struct ListNode *curr = preCurr->next;
			preCurr->next = curr->next;

			curr->next = pos->next;
			pos->next = curr;
    	}
    }
    return newHead->next;
}