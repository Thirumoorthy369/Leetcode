class Solution {
    public int longestPalindrome(String[] words) {
        int travel[][] = new int [26][26];
        int ans =0;

        for(String dr : words){
            int a = dr.charAt(0)-'a';
            int b = dr.charAt(1)-'a';

            if(travel[b][a] > 0){
                travel[b][a]--;
                ans += 4;
            }
            else travel[a][b]++;
        }

        for(int i=0; i<26; i++){
            if(travel[i][i] > 0) return ans +2;
        }
        return ans;
    }
}