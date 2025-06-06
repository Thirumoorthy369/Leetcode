class Solution {
    public long countSubarrays(int[] nums, int k) {
    int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int left = 0, count = 0;
        long res = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {
            if (nums[right] == max) {
                count++;
            }

            while (count >= k) {
                
                res += (n - right);
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
        }

        return res;
    }
    
}