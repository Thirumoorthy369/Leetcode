class Solution:
    def countNegatives(self, grid):
        count = 0
        rows, cols = len(grid), len(grid[0])
        for i in range(rows):
            left, right = 0, cols - 1
            while left <= right:
                mid = (left + right) // 2
                if grid[i][mid] < 0:
                    right = mid - 1
                else:
                    left = mid + 1
            count += cols - left
        return count