class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next: return head
        odd, even, even_head = head, head.next, head.next
        while even and even.next:
            odd.next, even.next = even.next, even.next.next
            odd, even = odd.next, even.next
        odd.next = even_head
        return head