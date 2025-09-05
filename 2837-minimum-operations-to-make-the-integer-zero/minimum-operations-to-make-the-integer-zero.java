class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i = 0; i <= 60; i++){
            long s = (long)num1 - (long)i*num2;
            if(s < 0)continue;
            if(s < i)continue;
            int one = Long.bitCount(s);
            if(one <= i)return i;
        }
        return -1;
    }
}