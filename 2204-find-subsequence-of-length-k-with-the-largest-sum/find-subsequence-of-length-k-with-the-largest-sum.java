import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Store value + original index
        int[][] valWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            valWithIndex[i][0] = nums[i];
            valWithIndex[i][1] = i;
        }

        // Step 2: Sort by value descending
        Arrays.sort(valWithIndex, (a, b) -> Integer.compare(b[0], a[0]));

        // Step 3: Take top-k and sort by index ascending
        Arrays.sort(valWithIndex, 0, k, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 4: Build result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = valWithIndex[i][0];
        }

        return result;
    }
}
