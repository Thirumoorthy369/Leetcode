class Solution {
    public int alternateDigitSum(int n) {
        String strnum = Integer.toString(n);
        int sum = 0;
        for(int i = 0; i < strnum.length(); i++) {
            int digit = strnum.charAt(i) - '0'; // Convert char to int
            if(i % 2 == 0) sum += digit;
            else sum -= digit;
        }
        return sum;
    }
}
