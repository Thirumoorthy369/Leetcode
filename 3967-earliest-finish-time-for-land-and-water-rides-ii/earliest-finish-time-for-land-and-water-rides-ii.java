import java.util.*;

class Solution {

    private long solve(int[] firstStart, int[] firstDuration,
                       int[] secondStart, int[] secondDuration) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDuration[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[m];
        long[] prefixMinDuration = new long[m];
        long[] suffixMinFinish = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefixMinDuration[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDuration[i] =
                Math.min(prefixMinDuration[i - 1], rides[i][1]);
        }

        suffixMinFinish[m - 1] =
            (long) rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            long val = (long) rides[i][0] + rides[i][1];
            suffixMinFinish[i] =
                Math.min(suffixMinFinish[i + 1], val);
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            long finishFirst =
                (long) firstStart[i] + firstDuration[i];

            int pos = upperBound(starts, (int) finishFirst);

            if (pos >= 0) {
                ans = Math.min(
                    ans,
                    finishFirst + prefixMinDuration[pos]
                );
            }

            if (pos + 1 < m) {
                ans = Math.min(
                    ans,
                    suffixMinFinish[pos + 1]
                );
            }
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l - 1;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans1 = solve(
            landStartTime, landDuration,
            waterStartTime, waterDuration
        );

        long ans2 = solve(
            waterStartTime, waterDuration,
            landStartTime, landDuration
        );

        return (int) Math.min(ans1, ans2);
    }
}