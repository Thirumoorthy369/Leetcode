class Solution:
    def thirdMax(self, nums):
        a = b = c = None
        for x in nums:
            if x in (a, b, c):
                continue
            if a is None or x > a:
                c, b, a = b, a, x
            elif b is None or x > b:
                c, b = b, x
            elif c is None or x > c:
                c = x
        return a if c is None else c