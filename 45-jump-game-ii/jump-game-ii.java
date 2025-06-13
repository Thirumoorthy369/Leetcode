class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0, c = 0;

        for(int i = 0; i < n-1; i++){
            a = Math.max(a, nums[i] + i);
            if(a >= n-1) return ++b;

            if(i == c){
                c = a;
                b++;
            }
        }
        return b;
    }
}

