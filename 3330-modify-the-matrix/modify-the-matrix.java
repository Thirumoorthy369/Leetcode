class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int ans[][] = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j =0; j < col; j++){

                if(matrix[i][j] == -1){
                ans[i][j] = matrix[i][j];

                for(int k = 0; k < row; k++){
                    if(ans[i][j] < matrix[k][j])
                        ans[i][j] = matrix[k][j];

                }
            } else{
                ans[i][j] = matrix[i][j];
            }
            }
        }
        return ans;
    }
}