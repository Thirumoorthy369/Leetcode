class Solution(object):
    def kthCharacter(self, k):
        """
        :type k: int
        :rtype: str
        """
        ind = k-1
        inc = 0
        while ind > 0:
            p = 1
            while p * 2 <= ind:
                p *= 2
            inc += 1
            ind -= p
        fin_char = ord('a') + (inc % 26)

        return chr(fin_char)        
        