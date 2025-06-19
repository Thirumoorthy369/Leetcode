class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int c = 0;
        int i = 0, j = 1;
        while(i < n && j < n){
            if(nums[j] - nums[i] <= k){
                j++;
                continue;
            }
            c++;
            i = j;
            j = j+1;
        }
        return c+1;
    }
}