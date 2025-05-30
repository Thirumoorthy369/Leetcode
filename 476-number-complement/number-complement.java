class Solution {
    public int findComplement(int num) {
        int k =1;
        while(k<num){
            k= (k<<1)|1;
        }
        return (num ^ k);
    }
}