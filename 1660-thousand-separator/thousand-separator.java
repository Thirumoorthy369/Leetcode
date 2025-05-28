class Solution {
    public String thousandSeparator(int n) {
        StringBuilder s = new StringBuilder(String.valueOf(n));
        int vari = s.length()-3;

        while(vari > 0){
            s.insert(vari,".");
            vari -= 3;
        }
        return s.toString();
    }
}