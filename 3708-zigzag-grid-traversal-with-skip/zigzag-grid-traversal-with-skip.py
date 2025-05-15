class Solution:
    def zigzagTraversal(self, grid: List[List[int]]) -> List[int]:
        for row in grid[1::2]:row.reverse()
        return list(chain(* grid))[::2]