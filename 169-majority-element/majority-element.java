class Solution {
    public int majorityElement(int[] nums) {
       int c = 0, x = 0;

       for(int n : nums){
        if(c == 0){
            x = n;
        }
        c += (x == n) ? 1 : -1;
       }
       return x;
    }
}