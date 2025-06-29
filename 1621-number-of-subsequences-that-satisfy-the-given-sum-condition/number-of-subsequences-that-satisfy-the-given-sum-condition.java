class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                
                count = (count + modPow(2, right - left, mod)) % mod;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

   
    private int modPow(int base, int exp, int mod) {
        long result = 1;
        long b = base;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }

        return (int) result;
    }
}
