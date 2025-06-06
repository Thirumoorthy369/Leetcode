class Solution {
    public int coinChange(int[] coins, int amount) {
        // 1. Create the DP array
        int[] dp = new int[amount + 1]; 
        // 2. Initialize the DP array
        Arrays.fill(dp, amount + 1);  
           dp[0] = 0;
        // 3. Iterate through the amounts and coins
        for (int i = 1; i <= amount; i++) {   
            for (int coin : coins) {          // For each amount, try using each available coin
                if (coin <= i) {             
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);  
                }
            }
        }

        // 4. Return the result
        return (dp[amount] > amount) ? -1 : dp[amount]; 
    }
}