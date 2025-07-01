class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int m = word.length();
        int c = n;
        for(int i = 1; i < m; i++){
            if(word.charAt(i) != word.charAt(i-1)){
                c--;
            }
        }
        return c;
    }
}