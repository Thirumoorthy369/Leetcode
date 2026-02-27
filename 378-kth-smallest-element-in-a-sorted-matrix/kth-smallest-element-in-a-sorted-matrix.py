class Solution:
    def kthSmallest(self, matrix, k):
        left, right = matrix[0][0], matrix[-1][-1]
        while left < right:
            mid = left + (right - left) // 2
            if self.count_le(matrix, mid) >= k:
                right = mid
            else:
                left = mid + 1
        return left
    
    def count_le(self, matrix, x):
        n = len(matrix)
        count = 0
        col = n - 1
        for row in range(n):
            while col >= 0 and matrix[row][col] > x:
                col -= 1
            count += col + 1
        return count