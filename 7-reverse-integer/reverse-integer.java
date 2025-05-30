class Solution {
    public int reverse(int n) {
         long reverse = 0;
        while(n!=0){
            reverse = reverse*10 + n%10;
            n/=10;
            if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
            return 0;
        }
        return (int)reverse;

    }
}