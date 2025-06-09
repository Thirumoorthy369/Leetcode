class Solution {
  public int mostFrequentEven(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    int maxCount = 0;
    int result = -1;
    for (int n : nums) {
      if (n % 2 == 0) {
        int count = freq.getOrDefault(n, 0);
        freq.put(n, count + 1);
        if (freq.get(n) > maxCount || (freq.get(n) == maxCount && n < result)) {
          maxCount = freq.get(n);
          result = n;
        }
      }
    }
    return result;
  }
}