class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0)return 0;
        if(n == 1)return nums[0];

        int case1 = roob(nums,0,n-2);
        int case2 = roob(nums,1,n-1);

        return Math.max(case1, case2);
    }
    public int roob(int [] nums, int start, int end){
        int prev=0; int curr=0;
        for(int i=start; i <= end; ++i){
            int next = Math.max(curr, prev+nums[i]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}


