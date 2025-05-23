class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        int count = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int num : nums) {
            int xorVal = num ^ k;
            if (xorVal > num) {
                totalSum += xorVal;
                count++;
                minDiff = Math.min(minDiff, xorVal - num);
            } else {
                totalSum += num;
                minDiff = Math.min(minDiff, num - xorVal);
            }
        }

        // If count is even, all good. If odd, subtract the smallest difference.
        if (count % 2 == 0) {
            return totalSum;
        } else {
            return totalSum - minDiff;
        }
    }
}
