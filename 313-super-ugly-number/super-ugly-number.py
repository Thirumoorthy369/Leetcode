class Solution:
    def nthSuperUglyNumber(self, n, primes):
        k = len(primes)
        dp = [1] * n
        idx = [0] * k
        vals = primes[:]

        for i in range(1, n):
            nxt = min(vals)
            dp[i] = nxt
            for j in range(k):
                if vals[j] == nxt:
                    idx[j] += 1
                    vals[j] = dp[idx[j]] * primes[j]
        return dp[-1]