public class Solution {

    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();

        // left[i]  → information about partitioning prefix s[0..i-1]
        // right[i] → information about partitioning suffix s[i..n-1]
        //
        // Each row has 3 fields:
        // [0] = number of full partitions made so far
        // [1] = bitmask representing which characters are currently active in the unfinished partition
        // [2] = how many distinct characters are in that unfinished partition
        int[][] left = new int[n][3];
        int[][] right = new int[n][3];

        //------------------------------------------------------------------
        // 1️⃣  Build prefix info (simulate partitioning from left → right)
        //------------------------------------------------------------------
        int num = 0;   // number of partitions completed
        int mask = 0;  // bitmask of current partition's distinct chars
        int count = 0; // number of distinct chars in current partition

        for (int i = 0; i < n - 1; i++) {
            int bit = 1 << (s.charAt(i) - 'a'); // map 'a'..'z' → 1 bit each

            // if this char is new in the current partition
            if ((mask & bit) == 0) {
                count++;
                if (count <= k) {
                    // still within the allowed k distinct chars
                    mask |= bit;
                } else {
                    // too many distinct chars — start a new partition
                    num++;
                    mask = bit;  // reset mask to only this new char
                    count = 1;
                }
            }

            // store current prefix state just after processing s[i]
            left[i + 1][0] = num;   // how many partitions fully done
            left[i + 1][1] = mask;  // bitmask of ongoing partition
            left[i + 1][2] = count; // distinct chars in ongoing partition
        }

        //------------------------------------------------------------------
        // 2️⃣  Build suffix info (simulate partitioning from right → left)
        //------------------------------------------------------------------
        num = 0;
        mask = 0;
        count = 0;
        for (int i = n - 1; i > 0; i--) {
            int bit = 1 << (s.charAt(i) - 'a');

            // same idea, but traversing backwards
            if ((mask & bit) == 0) {
                count++;
                if (count <= k) {
                    mask |= bit;
                } else {
                    num++;
                    mask = bit;
                    count = 1;
                }
            }

            // store suffix state just before index i
            right[i - 1][0] = num;
            right[i - 1][1] = mask;
            right[i - 1][2] = count;
        }

        //------------------------------------------------------------------
        // 3️⃣  Try changing every single index once
        //------------------------------------------------------------------
        int maxVal = 0;

        for (int i = 0; i < n; i++) {
            // If we split the string at i (change s[i]), we combine:
            //  - left[i]: partitions before this index
            //  - right[i]: partitions after this index
            //
            // "+2" accounts for one active partition on each side
            int seg = left[i][0] + right[i][0] + 2;

            // merge masks from both sides to see total distinct chars if we glue them
            int totMask = left[i][1] | right[i][1];
            int totCount = Integer.bitCount(totMask); // number of distinct chars combined

            // \U0001f9e0 Adjust partitions based on whether changing s[i] helps or hurts

            // Case 1: both sides are "full" (each already has k distinct chars)
            // but by changing s[i] to a new letter not seen yet, we can
            // *force* an extra partition break between them.
            if (left[i][2] == k && right[i][2] == k && totCount < 26) {
                seg++; // gain an extra partition
            }

            // Case 2: otherwise, maybe changing s[i] merges two partitions
            // (because now total distinct <= k), so we lose one break
            else if (Math.min(totCount + 1, 26) <= k) {
                seg--; // fewer partitions
            }

            maxVal = Math.max(maxVal, seg);
        }

        //------------------------------------------------------------------
        // 4️⃣  Return the maximum partitions found
        //------------------------------------------------------------------
        return maxVal;
    }
}
