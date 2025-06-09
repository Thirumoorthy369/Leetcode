class Solution {
    final int mod = (int)1e9 + 7;

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;

        for (int d : deliciousness) {
            
            for (int i = 0; i <= 21; i++) {
                int target = (1 << i);
                int complement = target - d;
                count = (count + map.getOrDefault(complement, 0)) % mod;
            }
            
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        return (int) count;
    }
}
