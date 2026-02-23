class Solution:
    def searchRange(self, nums, target):
        def binary_search_left():
            left, right = 0, len(nums)
            while left < right:
                mid = left + (right - left) // 2
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid
            return left
        def binary_search_right():
            left, right = 0, len(nums)
            while left < right:
                mid = left + (right - left) // 2
                if nums[mid] <= target:
                    left = mid + 1
                else:
                    right = mid
            return left - 1
        
        left_bound = binary_search_left()
        right_bound = binary_search_right()
        if left_bound <= right_bound and left_bound < len(nums) and nums[left_bound] == target:
            return [left_bound, right_bound]
        return [-1, -1]
