class Solution {
    public int findFinalValue(int[] nums, int original) {
        //int val = 0;
        int i =0;
        while(i<nums.length){
            if(nums[i] == original) {
                original = 2 * nums[i];
                i=0;
            }
            else i++;

        }
        return original;
    }
}