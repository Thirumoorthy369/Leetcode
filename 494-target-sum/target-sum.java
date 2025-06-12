class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        
        findtarget(nums, 0, 0, target);
        return count;
    }
    private void findtarget(int [] nums, int ind, int n, int tar){
        if(ind == nums.length){
            if(n == tar){
                count++;
            }
            return;
        }
        findtarget(nums, ind + 1, n + nums[ind], tar);
        findtarget(nums, ind + 1, n - nums[ind], tar);
    }
}