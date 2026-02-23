class Solution:
    def spiralOrder(self, matrix):
        if not matrix or not matrix[0]: return []
        
        res, top, bottom, left, right = [], 0, len(matrix)-1, 0, len(matrix[0])-1
        
        while top <= bottom and left <= right:
            # Right → Left across top row
            for col in range(left, right + 1):
                res.append(matrix[top][col])
            top += 1
            
            # Down → Top across right column  
            for row in range(top, bottom + 1):
                res.append(matrix[row][right])
            right -= 1
            
            # Left → Right across bottom row
            if top <= bottom:
                for col in range(right, left - 1, -1):
                    res.append(matrix[bottom][col])
                bottom -= 1
            
            # Up → Down across left column
            if left <= right:
                for row in range(bottom, top - 1, -1):
                    res.append(matrix[row][left])
                left += 1
        
        return res
