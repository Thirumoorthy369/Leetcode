/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }

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
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
           HashSet<ListNode> hs = new HashSet<>();

           while(headA != null){
            hs.add(headA);
            headA = headA.next;
           }

           while(headB != null){
            if(hs.contains(headB)) return headB;
            else headB = headB.next;
           }
           return null;
    }
}