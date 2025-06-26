class Solution {
    int ans=0;
    Integer dp[][];
    public int longestSubsequence(String s, int k) {
            dp=new Integer[s.length()+1][s.length()+1];
    return fun(s,s.length()-1,k,0,0);
    }
    int fun(String s,int i,int k,int tmp,int len)
    {
        if(i==-1)
            return 0;
        if(dp[i][len]!=null)
            return dp[i][len];
        int taken=0;
        if((int)(s.charAt(i)-'0')*Math.pow(2,len)+tmp<=k)
        taken=1+fun(s,i-1,k,(int)(s.charAt(i)-'0')*(int)Math.pow(2,len)+tmp,len+1);
        int nottaken=fun(s,i-1,k,tmp,len);
        return dp[i][len]=Math.max(nottaken,taken); 
    }
    
}