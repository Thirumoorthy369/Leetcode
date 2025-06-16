class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int a = nums[0];
        int max = -1;
        for(int i = 0; i < n; i++){
            if(nums[i] > a){
                max = Math.max(max, nums[i] - a);
            }
            else
                a = nums[i];
        }
        return max;
    }
}