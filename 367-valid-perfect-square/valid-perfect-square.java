class Solution {
    public boolean isPerfectSquare(int num) {
        return ((int)(Math.sqrt(num))* Math.sqrt(num)== num) ? true : false;
    }
}