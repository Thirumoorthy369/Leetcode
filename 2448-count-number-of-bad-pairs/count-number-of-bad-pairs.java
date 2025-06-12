class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        long goodp = 0;

        for(int i = 0; i < nums.length; i++){
            int key = nums[i] - i;
            long freq = map.getOrDefault(key, 0L);
            goodp += freq;
            map.put(key, freq +1);
        }
        long totalpairs = (long) nums.length * (nums.length - 1) /2;
        return totalpairs - goodp;
    }
}