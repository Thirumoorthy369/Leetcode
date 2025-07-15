class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[]  = new int[amount +1];

        for(int i = 1; i <= amount; i++){
            dp[i] = amount+1;;
            for(int coin : coins){
                int t = i - coin;
                if (t < 0) break;
                dp[i] =  Math.min(dp[i] , dp[t]+1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}