class Solution:
    def generateMatrix(self, n):
        mat = [[0]*n for _ in range(n)]
        num = 1
        for layer in range((n + 1)//2):
            l, r = layer, n - layer - 1
            for c in range(l, r + 1):
                mat[l][c] = num; num += 1
            for rrow in range(l + 1, r + 1):
                mat[rrow][r] = num; num += 1
            if l < r:
                for c in range(r - 1, l - 1, -1):
                    mat[r][c] = num; num += 1
                for rrow in range(r - 1, l, -1):
                    mat[rrow][l] = num; num += 1
        return mat