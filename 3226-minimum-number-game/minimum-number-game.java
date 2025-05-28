class Solution {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        int a = 0; int b = 1;
        Arrays.sort(nums);
        while(b <= n-1){
            int temp = nums[b];
            nums[b] = nums[a];
            nums[a] = temp;
            a += 2;
            b += 2;
        }
        return nums;
    }
}