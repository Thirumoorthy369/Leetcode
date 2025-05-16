class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxp = 0, pricesize = prices.size(), minprice = prices[0];

    for(int index = 0; index < pricesize; index++){
        if(prices[index] < minprice) minprice = prices[index];

        if(prices[index] - minprice > maxp) maxp = prices[index] - minprice;
    }
    return maxp;
    }
};