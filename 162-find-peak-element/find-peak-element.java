class Solution {
    public int findPeakElement(int[] nums) {
        int le = 0, ri = nums.length-1;
        while(le < ri){
            int mid = le + (ri - le) / 2;
            if(nums[mid] > nums[mid+1]){
                ri = mid;
            }
            else{
                le = mid + 1;
            }
        }
        return le;
    }
}