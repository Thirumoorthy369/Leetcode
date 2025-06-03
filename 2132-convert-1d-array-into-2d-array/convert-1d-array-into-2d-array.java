class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int o = original.length;
        if(m * n != o) 
        return new int[0][0]; 
        int arr[][] = new int[m][n]; int ind =0;
        
        for(int i=0; i<m;i++){
          for(int j=0; j < n; j++){
                arr[i][j] = original[ind++];
          }  
        }
        return arr;
    }
}