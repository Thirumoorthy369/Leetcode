class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend == 0: return 0
        sign = 1 if (dividend > 0) == (divisor > 0) else -1
        dividend, divisor = abs(dividend), abs(divisor)
        left, right = 0, dividend
        while left <= right:
            mid = (left + right) // 2
            if mid * divisor <= dividend: left = mid + 1
            else: right = mid - 1
        return max(min(sign * right, 2**31 - 1), -2**31)