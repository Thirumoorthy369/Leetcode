class Solution {
    public int arraySign(int[] nums) {
    //     int n =  nums.length;
    //     int prod = 1;
    //     for(int i=0;i<n;i++){
    //         prod = prod * nums[i];
    //     }
    //     return signFunc(prod);
    // }
    // public int signFunc(int x){
    //     if(x>0) return 1;
    //     else if(x == 0) return 0;
    //     return -1;
    // }
     int sign = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) sign *= -1;
        }
        return sign;
    }
}