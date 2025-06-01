class Solution {
    public long distributeCandies(int n, int limit) {
        long candy = 0;

        int min1 = Math.max(0, n - 2* limit);
        int max1 = Math.min(limit, n );

        for(int i= min1; i<= max1; i++){
            int min2 = Math.max(0, n-i-limit);
            int max2 = Math.min(limit, n-i);
            candy += max2 - min2 +1;
        }
        return candy;
    }
}