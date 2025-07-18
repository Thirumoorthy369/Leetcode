import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums); 

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        int answer = 0;

        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canFormAtLeastPPairs(nums, p, mid)) {
                answer = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }

        return answer;
    }

    //feasibility func using greedy alg
    private boolean canFormAtLeastPPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2;
            } else {
                i += 1;
            }
        }

        return count >= p;
    }
}
