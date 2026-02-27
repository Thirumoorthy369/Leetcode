class Solution:
    def countGoodNumbers(self, n: int) -> int:
        MOD = 10**9 + 7
        even_count = (n + 1) // 2   
        odd_count = n // 2          
        even_ways = pow(5, even_count, MOD)
        odd_ways = pow(4, odd_count, MOD)
        return (even_ways * odd_ways) % MOD