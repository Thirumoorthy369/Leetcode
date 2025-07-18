import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        if (n % 3 != 0) return new int[0][0];

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < n; i += 3) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];

            if (c - a > k) {
                return new int[0][0];  // Not valid group
            }

            res.add(new int[]{a, b, c});
        }

        return res.toArray(new int[res.size()][]);
    }
}
