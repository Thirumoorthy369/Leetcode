class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int count = 0;
        int col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] < 0){
                    count++;
                }
            }
        }
        return count > 0 ? count : 0;
    }
}