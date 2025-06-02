class Solution {
    public int[][] generateMatrix(int n) {
       int arr[][] = new int [n][n];
        int cls = 0;
        int ros = 0;
        int cle = n - 1;
        int roe = n -1;
        int end = n*n;
        int data = 1;

        while(data<=end){
             for(int i=cls; i<= cle; i++){
            arr[ros][i] = data;
            data++;
             }
            ros++;

            for(int i=ros; i<= roe;i++){
            arr[i][cle] = data; 
            data++;
            }
            cle--;

            if(ros <= roe){
            for(int i=cle; i>=cls;i--){
            arr [roe][i] = data;
            data++;
            }
            }
            roe--;

            if(cls <= cle){
                for(int i= roe; i>= ros; i--){
                arr[i][cls] = data;
                data++;
                }
            cls++;    
            }
        }
        return arr;
    }
        
    }