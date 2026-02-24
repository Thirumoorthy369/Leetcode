class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        length, tail = 1, head
        while tail.next:
            length += 1
            tail = tail.next
        k = k % length
        if k == 0:
            return head
        curr = head
        for _ in range(length - k - 1):
            curr = curr.next
        new_head, new_tail = curr.next, curr
        tail.next, new_tail.next = head, None
        return new_head