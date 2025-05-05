class Solution(object):
    def minBitwiseArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []

        for num in nums:
            if num == 2:
                result.append(-1)
            else:
                # Try to find the least significant 0 bit in num
                for i in range(1, 32):  # 32 bits is enough for int range
                    if ((num >> i) & 1) == 0:
                        ans = num ^ (1 << (i - 1))
                        result.append(ans)
                        break

        return result
