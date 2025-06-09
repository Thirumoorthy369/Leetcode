class Solution {
    public long interchangeableRectangles(int[][] rect) {
        long n = rect.length, res = 0;
        Map<Double,Integer>hr = new HashMap<>();

        for(int i = 0; i < n; i++){
            double rat = (double) rect[i][0] / rect[i][1];

            res += hr.getOrDefault(rat, 0);
            hr.put(rat, hr.getOrDefault(rat, 0) + 1);
        }
        return res;
    }
}