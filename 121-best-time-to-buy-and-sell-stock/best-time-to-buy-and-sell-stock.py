class Solution:
    def maxProfit(self, prices):
        buy=prices[0]
        mp=0
        for i in range(1,len(prices)):
            if(buy>prices[i]):
                buy=prices[i]
            cp=prices[i]-buy
            mp=max(cp,mp)
        return mp
