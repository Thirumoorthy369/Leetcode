class Solution {
    public int commonFactors(int a, int b) {
        int n =0;
        int count  = Math.min(a,b);
        
        for(int i=1;i<=count; i++){
            if(a%i == 0 && b%i == 0)
            n++;
        }
        return n;
    }
}