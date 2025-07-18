import java.util.*;

public class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;

        long[] leftSums = new long[2 * n];
        long leftSum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];
            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            if (maxHeap.size() == n) {
                leftSums[i] = leftSum;
            }
        }

        long[] rightSums = new long[2 * n + 1];
        long rightSum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 3 * n - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];
            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                rightSums[i] = rightSum;
            }
        }

        long res = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            res = Math.min(res, leftSums[i] - rightSums[i + 1]);
        }

        return res;
    }
}
