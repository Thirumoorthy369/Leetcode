class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        from collections import deque
        from itertools import accumulate
        n = len(nums)
        ans = n + 1
        dq = deque()
        prefix = list(accumulate(nums, initial=0))
        for i in range(n + 1):
            while dq and prefix[i] - prefix[dq[0]] >= k:
                ans = min(ans, i - dq.popleft())
            while dq and prefix[i] <= prefix[dq[-1]]:
                dq.pop()
            dq.append(i)
        if ans <= n:
            return ans
        else:
            return -1
