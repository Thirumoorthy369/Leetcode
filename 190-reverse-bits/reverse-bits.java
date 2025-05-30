public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int results = 0;
          for (int i = 0; i < 32; i++) {
            results <<= 1;         // Shift result to the left to make space for the new bit
            results |= (n & 1);    // Take the last bit of n and add it to result
            n >>>= 1;             // Unsigned right shift n to process the next bit
        }
        return results;
    }
}