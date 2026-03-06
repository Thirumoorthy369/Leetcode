class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        found_zero_after_one = False
        for ch in s:
            if ch == '0':
                found_zero_after_one = True
            else: 
                if found_zero_after_one:
                    return False
        return True