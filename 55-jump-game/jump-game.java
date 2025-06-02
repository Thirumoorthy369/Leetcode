

class Solution {
    public boolean canJump(int[] nums) {
        int LG = nums.length - 1;

        for(int i= nums.length-2; i>=0; i--){
            if(i + nums[i] >= LG )
            LG = i;
        }

        return LG == 0;
    }
}
