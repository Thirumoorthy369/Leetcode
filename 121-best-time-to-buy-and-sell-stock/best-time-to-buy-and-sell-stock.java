class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0, pricesize = prices.length, minprice = prices[0];

    for(int index = 0; index < pricesize; index++){
        if(prices[index] < minprice) minprice = prices[index];

        if(prices[index] - minprice > maxp) maxp = prices[index] - minprice;
    }
    return maxp;
    }
}