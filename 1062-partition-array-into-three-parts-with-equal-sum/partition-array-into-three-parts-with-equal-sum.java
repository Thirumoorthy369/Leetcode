class Solution {
     public boolean canThreePartsEqualSum(int[] num) {
      int sum = Arrays.stream(num).sum();

      if(sum %3 != 0) return false;
       int tsum = sum/3, temp = 0, found = 0;

       for(int i=0; i<num.length;i++){
        temp += num[i];
        if(temp == tsum){
            temp = 0;
            found++;
        }
       }
        return found>=3 ? true : false;
    }  

}