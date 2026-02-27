class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        clean = ''.join(c.upper() for c in s if c != '-')
        groups = []
        for i in range(len(clean), 0, -k):
            start = max(0, i - k)
            groups.append(clean[start:i])
        return '-'.join(reversed(groups))