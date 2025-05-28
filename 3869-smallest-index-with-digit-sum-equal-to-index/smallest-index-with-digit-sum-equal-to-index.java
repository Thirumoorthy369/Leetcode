class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            int sum = Sum(nums[i]);
            if(sum == i)return i;
        }
        return -1;
    }
    public int Sum(int n){
        int val =0;
        while(n != 0){
            int s1 = n%10;
            val += s1;
            n = n/10;
        }
        return val;
    }
}