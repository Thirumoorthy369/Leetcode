class Solution {
    public int hammingWeight(int n) {
        int co = 0;
        while(n >0){
            if(n%2==1)co++;
            n/=2;
        }
        return co;
    }
}