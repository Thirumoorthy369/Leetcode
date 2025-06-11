class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
       return  searching(nums, n, target);
        // return sw;
    }

    public int searching(int[] nums, int n, int k){
        int low = 0, high = n-1;

        while(low <= high){
            int mid = (low + high) / 2;

             if (nums[mid] == k) return mid;

            if(nums[low] <= nums[mid]){
                if(nums[low] <= k && k <= nums[mid])
                    high = mid -1;
               else low = mid + 1;
            }

            else{
                if(nums[mid] <= k && k <= nums[high])
                    low = mid +1;
                else high = mid -1;
            }
        }
        return -1;
    }
}