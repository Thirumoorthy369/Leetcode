class Solution {
    public boolean isMonotonic(int[] nums) {
       int n = nums.length;
       if(n == 1)
        {
            return true;
        }
        
        boolean a=true; boolean b=true;;
        for(int j=1;j<n;j++)
        {
            if(nums[j]<nums[j-1])
            {
                a=false;
                break;
            }
        }
        for(int j=1;j<n;j++)
        {
            if(nums[j]>nums[j-1])
            {
                b=false;
                break;
            }
        }
        return a || b;
    }
}