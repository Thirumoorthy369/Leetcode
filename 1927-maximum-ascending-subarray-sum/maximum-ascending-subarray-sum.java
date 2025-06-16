class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int c_sum = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1])
                c_sum += nums[i];
            else
                c_sum = nums[i];

            max = Math.max(max, c_sum);        
        }
        return max;
    }
}