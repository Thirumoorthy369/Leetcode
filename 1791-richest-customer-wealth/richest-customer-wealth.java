public class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int maxWealth = 0;

        for (int[] account : accounts) {
            int currentWealth = 0;
            for (int money : account) {
                currentWealth += money;
            }   
            maxWealth = Math.max(maxWealth, currentWealth);
        }
        return maxWealth;
    }
}
