class Solution {
    public int findNonMinOrMax(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // if(n <= 2) return -1;

        for(int i=0; i< n;i++){
            int res = 0;
            if(nums[i] == nums[0] || nums[i] == nums[n-1]) continue;
           return  res = nums[i];
        }
        return -1;
    }
}