class Solution {
    public int minDays(int[] arr, int m, int k) {
        long totalFlowersNeeded = (long) m * k;
        if (arr.length < totalFlowersNeeded) {
            return -1;
        }

        int low = getMin(arr);
        int high = getMax(arr);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
        }
        return min;
    }

    private int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private boolean isPossible(int[] arr, int day, int m, int k) {
        int bouquets = 0;
        int flowers = 0;

        for (int num : arr) {
            if (num <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0; 
            }
        }

        return bouquets >= m;
    }
}
