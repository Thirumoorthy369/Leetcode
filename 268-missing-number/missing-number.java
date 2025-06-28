class Solution {
    public int missingNumber(int[] num) {
        int n = num.length;
        int exp = (n*(n+1))/2;
        int abs = 0;
        for(int n1 : num){
            abs += n1;
        }
        return exp - abs;
    }
}