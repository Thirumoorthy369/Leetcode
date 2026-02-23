class Solution:
    def maxProfit(self, prices):
        if len(prices) < 2:
            return 0
        
        min_price = prices[0]
        max_profit = 0
        for price in prices[1:]:
            max_profit = max(max_profit, price - min_price)
            min_price = min(min_price, price)
        return max_profit
