class Solution(object):
    def countSubarrays(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        left = 0
        current_sum = 0
        count = 0
        for right in range(len(nums)):
            current_sum += nums[right]
            while current_sum * (right - left + 1) >= k:
                current_sum -= nums[left]
                left += 1
            count += right - left + 1
        return count