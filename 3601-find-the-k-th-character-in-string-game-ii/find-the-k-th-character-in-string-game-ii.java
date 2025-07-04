class Solution {
    public char kthCharacter(long k, int[] operations) {
        long A = 0;

        // Step 1: Get the bit length of (k - 1)
        int bitLength = 64 - Long.numberOfLeadingZeros(k - 1);

        // Step 2: Build the shift mask (A)
        for (int b = 0; b < bitLength && b < operations.length; b++) {
            A |= ((long) operations[b] << b);
        }

        // Step 3: Mask the path and count the number of 1s (number of shifts)
        long masked = (k - 1) & A;
        int shiftCount = Long.bitCount(masked);

        // Step 4: Return the shifted character
        return (char) ('a' + (shiftCount % 26));
    }
}

