class Solution:
    def findRelativeRanks(self, score):
        res = [""] * len(score)
        for r, i in enumerate(sorted(range(len(score)), key=score.__getitem__, reverse=True)):
            res[i] = ["Gold Medal","Silver Medal","Bronze Medal"][r] if r<3 else str(r+1)
        return res