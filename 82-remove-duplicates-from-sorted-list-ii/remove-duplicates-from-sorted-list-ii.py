class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy=ListNode(0); dummy.next=head; prev=dummy
        while prev.next and prev.next.next:
            if prev.next.val==prev.next.next.val:
                v=prev.next.val
                while prev.next and prev.next.val==v: prev.next=prev.next.next
            else: prev=prev.next
        return dummy.next