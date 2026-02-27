class Solution:
    def frequencySort(self, s: str) -> str:
        from collections import Counter
        
        # Count frequency of each character
        count = Counter(s)
        
        # Sort characters by frequency (descending), then by char (ascending)
        chars = sorted(count.keys(), key=lambda c: (-count[c], c))
        
        # Build result string
        result = ''
        for c in chars:
            result += c * count[c]
        
        return result