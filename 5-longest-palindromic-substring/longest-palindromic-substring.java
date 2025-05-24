class Solution {
    public String longestPalindrome(String s) {
        int s1 = s.length();
        if(s1 <= 1) return s;

        int maxlength = 1;
        String maxstr = s.substring(0,1);

        for(int i=0; i< s1; i++){
            for(int j= i+maxlength ; j <= s1; j++){
                 if (j - i > maxlength && isPalindrome(s.substring(i, j))) {
                    maxlength = j - i;
                    maxstr = s.substring(i, j);
                }
            }
        }
        return maxstr;
    }

       private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}