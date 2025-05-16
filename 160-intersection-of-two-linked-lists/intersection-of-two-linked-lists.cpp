/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        unordered_set <ListNode*>s;
        while(headA != nullptr){
            s.insert(headA);
            headA = headA -> next;
        }
        while(headB != nullptr){
            if(s.count(headB)==1) return headB;
            else headB = headB -> next;
        }
        return nullptr;
    }
};