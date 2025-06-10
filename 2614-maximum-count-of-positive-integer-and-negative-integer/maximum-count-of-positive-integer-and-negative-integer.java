class Solution {
    public int maximumCount(int[] nums) {
        int nc = firstIndex(nums, 0);      // count of negatives
        int pc = nums.length - firstIndex(nums, 1); // count of positives
        return Math.max(nc, pc);
    }

    
    private int firstIndex(int[] nums, int target) {
        int left = 0, right = nums.length; //two pointers
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;

    }
}