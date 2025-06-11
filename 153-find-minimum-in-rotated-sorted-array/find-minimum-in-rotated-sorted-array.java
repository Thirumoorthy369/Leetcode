class Solution {
    public int findMin(int[] nums) {
        int le = 0;
        int ri = nums.length -1;

        while(le < ri){
            int mid = (le + ri) / 2;

            if(nums[mid] <= nums[ri]) 
                ri = mid;
            else
                le = mid +1;    
        }
        return nums[le];
    }
}

