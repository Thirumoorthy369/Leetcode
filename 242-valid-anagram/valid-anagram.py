class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        l = "abcdefghijklmnopqrstuvwxyz"
        for c in l:
            if s.count(c) != t.count(c):
                return False
        return True
        