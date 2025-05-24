// class Solution {
//     public String longestPalindrome(String s) {
//         int s1 = s.length();
//         if(s1 <= 1) return s;

//         int maxlength = 1;
//         String maxstr = s.substring(0,1);

//         for(int i=0; i< s1; i++){
//             for(int j= i+maxlength ; j <= s1; j++){
//                  if (j - i > maxlength && isPalindrome(s.substring(i, j))) {
//                     maxlength = j - i;
//                     maxstr = s.substring(i, j);
//                 }
//             }
//         }
//         return maxstr;
//     }

//        private boolean isPalindrome(String str) {
//         int left = 0;
//         int right = str.length() - 1;

//         while (left < right) {
//             if (str.charAt(left) != str.charAt(right)) {
//                 return false;
//             }
//             left++;
//             right--;
//         }

//         return true;
//     }
// }

class Solution {
    int start = 0;
    int end = 0;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        solve(s.toCharArray(), 0);
        return s.substring(start, end + 1);
    }

    public void solve(char[] s, int index) {
        if (index >= s.length - 1) {
            return;
        }

        int left = index;
        int right = index;

        while (right < s.length - 1 && s[right] == s[right + 1]) {
            right++;
        }
        index = right;

        while (left > 0 && right < s.length - 1 && s[left - 1] == s[right + 1]) {
            left--;
            right++;
        }

        if (end - start < right - left) {
            start = left;
            end = right;
        }
        solve(s, index + 1);
    }

}