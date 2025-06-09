public class Solution {
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        k = k - 1; 

        while (k > 0) {
            long count = getCount(prefix, n);

            if (count <= k) {
               
                prefix++;
                k -= count;
            } else {
                
                prefix *= 10;
                k -= 1;
            }
        }

        return prefix;
    }

    private long getCount(long prefix, int n) {
        long count = 0;
        long curr = prefix;
        long next = prefix + 1;

        while (curr <= n) {
            count += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }

        return count;
    }
}
