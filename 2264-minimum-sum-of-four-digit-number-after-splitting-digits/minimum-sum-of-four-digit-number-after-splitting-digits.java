class Solution {
    public int minimumSum(int num) {
        ArrayList<Integer> digits = new ArrayList<>();
        while(num >0){
            digits.add(num%10);
            num /= 10;
        }

        Collections.sort(digits);

         int new1 = digits.get(0) * 10 + digits.get(2);
        int new2 = digits.get(1) * 10 + digits.get(3);

        return new1 + new2;
    }
}