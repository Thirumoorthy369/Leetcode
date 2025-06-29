class Solution {
    public String reverseWords(String s) {
        String[] word = s.trim().split("\\s+");

        int l = 0, r = word.length -1;
        while(l < r){
            String temp = word[l];
            word[l] = word[r];
            word[r] = temp;
            l++;
            r--;
        }
        String reverse = String.join(" ",word);
        return reverse;
    }
}