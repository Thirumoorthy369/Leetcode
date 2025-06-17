class Solution {

    static long mod = (long)(1e9)+7;
    static long fact[];
    static long invFact[];
    static long power(long base, long exp) {
        long result = 1L;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }


    static long nCr(int n, int r){
        if(r<0 || r>n) return 0;
        
        long a = fact[n];
        long b = invFact[r];
        long c = invFact[n-r];
        return ((a*b)%mod*c)%mod;
    }

    static void preCompute(int n){
        fact = new long[n+1];
        invFact = new long[n+1];

        fact[0] = 1;
        for(int i=1; i<=n; i++){
            fact[i] = ((fact[i-1]%mod)*(i))%mod;
        }
        
        invFact[n] = power(fact[n],mod-2)%mod;
        for(int i=n-1; i>=0; i--){
            invFact[i] = ((invFact[i+1]%mod)*(i+1))%mod;
        }
    }
    
    public int countGoodArrays(int n, int m, int k) {
        preCompute(n);
        long b = n-k;
        long c = nCr(n-1,k);
        long ans = power(m-1,b-1);
        ans = (ans*m)%mod;
        ans = (ans*c)%mod;
        return (int)ans;
    }
}