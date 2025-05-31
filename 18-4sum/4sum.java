/*
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int temp = target - nums[i];
            if (!map.containsKey(temp)) {
                map.put(nums[i], i);
            } else {
                return new int[] { map.get(temp), i };
            }
        }

        return new int[] { 0, 0 };  // default return, though problem usually assumes one valid answer
    }
}




class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Step 2: Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Step 3: Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Increase sum
                } else {
                    right--; // Decrease sum
                }
            }
        }

        return result;
    }
}
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array to handle duplicates and use two pointers
        return kSum(nums, target, 4, 0);
    }

    private List<List<Integer>> kSum(int[] nums, long target, int k, int start) {
        List<List<Integer>> res = new ArrayList<>();

        if (start == nums.length) return res;

        // Base case: use two pointers to find pairs that sum up to target
        if (k == 2) {
            int left = start, right = nums.length - 1;

            while (left < right) {
                long sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[left], nums[right]));

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

        } else {
            // Recursive case: reduce k-sum to (k-1)-sum
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // Skip duplicates

                List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);

                for (List<Integer> t : temp) {
                    List<Integer> current = new ArrayList<>();
                    current.add(nums[i]);
                    current.addAll(t);
                    res.add(current);
                }
            }
        }

        return res;
    }

}