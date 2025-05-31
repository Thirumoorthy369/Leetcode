class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int c = num.length-1;;
        List<Integer>n1 = new ArrayList<>();

        while(c>=0 || k>0){
           if(c>=0){
           k += num[c--];
           }
           n1.addFirst(k%10);
           k/=10;
        }
        
        return n1;
    }
}