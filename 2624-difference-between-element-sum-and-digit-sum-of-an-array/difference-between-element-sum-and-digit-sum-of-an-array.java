class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int sum2 = 0;

       for(int i=0; i<nums.length;i++){
        sum += nums[i];
       }

        for(int i=0; i<nums.length; i++){
            while(nums[i] != 0){
                sum2 += nums[i] % 10;
                nums[i] /= 10; 
            }
        }
        return sum - sum2;
    }
}