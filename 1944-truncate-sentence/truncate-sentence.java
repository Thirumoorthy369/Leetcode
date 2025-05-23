class Solution {
      public String truncateSentence(String s, int k) {
        String[] str=s.split(" ");
        StringBuilder truncatedSentence=new StringBuilder();
        for(int i=0;i<k-1;i++){
            truncatedSentence.append(str[i] +" ");
        }
        truncatedSentence.append(str[k-1]); 
        return truncatedSentence.toString();
    }
}