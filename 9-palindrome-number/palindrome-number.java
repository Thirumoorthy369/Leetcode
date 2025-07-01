class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x); // Convert to String
        int n = s.length(); // Store the String length to int n

        return s.equals(new StringBuilder(s).reverse().toString());
    }
}