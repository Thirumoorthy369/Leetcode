class Solution {
    public String reversePrefix(String word, char ch) {
        char[] wordra = word.toCharArray();

        for(int i = 0; i<wordra.length;i++){
            if(wordra[i]==ch){
                 int left = 0, right = i;
                while(left < right) {
                    char temp = wordra[left];
                    wordra[left] = wordra[right];
                    wordra[right] = temp;
                    left++;
                    right--;
                }
                break; 
            }
        }
        return new String(wordra);
    }
}