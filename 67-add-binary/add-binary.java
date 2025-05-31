import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger a1 = new BigInteger(a, 2);  // base 2
        BigInteger b2 = new BigInteger(b, 2);

        BigInteger sum = a1.add(b2);
        String result = sum.toString(2);  

        return result;
    }
}