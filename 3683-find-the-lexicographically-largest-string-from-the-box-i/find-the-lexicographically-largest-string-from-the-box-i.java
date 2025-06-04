class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;

        int n = word.length(), end;
        int split = n-numFriends;

        String curr = "", m = "";

        for(int i=0; i<n; i++){
            end = Math.min(n, i+split +1);
            curr = word.substring(i, end);
            if(curr.compareTo(m) > 0)
            m = curr;
        }
        return m;
    }
}