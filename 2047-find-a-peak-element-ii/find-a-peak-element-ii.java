class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int i = 0, j = 0;

        while(i < mat.length && j < mat[0].length){

            if(i > 0 && mat[i-1][j] > mat[i][j]) i = i - 1;
            else if(j > 0 && mat[i][j -1] > mat[i][j]) j = j - 1;
            else if(i + 1 < mat.length && mat[i+1][j] > mat[i][j]) i = i+1;
            else if(j + 1 < mat[0].length && mat[i][j+1] > mat[i][j]) j = j+1;
            else{
                int[] ans = {i,j};
                return ans;
            }
        }
        return new int[0];

    }
}