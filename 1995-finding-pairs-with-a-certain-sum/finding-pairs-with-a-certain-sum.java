class FindSumPairs {
    private int[] nums1, nums2;
    private Map<Integer,Integer> freq2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freq2 = new HashMap<>();
        for (int x : nums2) {
            freq2.merge(x, 1, Integer::sum);
        }
    }

    public void add(int index, int val) {
        int old = nums2[index];
        int updated = old + val;
        // Decrement old value count
        freq2.merge(old, -1, Integer::sum);
        // Update nums2 at index
        nums2[index] = updated;
        // Increment new value count
        freq2.merge(updated, 1, Integer::sum);
    }

    public int count(int tot) {
        int result = 0;
        for (int x : nums1) {
            result += freq2.getOrDefault(tot - x, 0);
        }
        return result;
    }
}
